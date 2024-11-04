package com.bootcamp.demo.demo_docker_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_docker_backend.entity.StockDailyEntity;
import com.bootcamp.demo.demo_docker_backend.infra.RedisHelper;
import com.bootcamp.demo.demo_docker_backend.infra.Scheme;
import com.bootcamp.demo.demo_docker_backend.infra.UrlBuilder;
import com.bootcamp.demo.demo_docker_backend.infra.time.DateTimeManager;
import com.bootcamp.demo.demo_docker_backend.model.dto.OHLCDTO;
import com.bootcamp.demo.demo_docker_backend.repository.StockDailyRepository;
import com.bootcamp.demo.demo_docker_backend.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class StockServiceImpl implements StockService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.demo-docker-external.domain}")
  private String domain;

  @Value("${api.demo-docker-external.port}")
  private String port;

  @Value("${api.demo-docker-external.names.endpoint}")
  private String endpoint;

  @Autowired
  private StockDailyRepository stockDailyRepository;

  @Autowired
  private DateTimeManager dateTimeManager;

  @Autowired
  private RedisHelper redisHelper;

  private OHLCDTO getFromRedis(String key) {
    try {
      return redisHelper.get(key, OHLCDTO.class);
    } catch (JsonProcessingException e) {
      return null;
    }
  }

  private void setOHLCToRedis(OHLCDTO ohlc) {
    try {
      redisHelper.set("OHLC", ohlc);
    } catch (JsonProcessingException e) {

    }
  }

  @Override
  public OHLCDTO getOHLC() {
    // Return directly if exists in Redis
    OHLCDTO ohlcFromRedis = this.getFromRedis("OHLC");
    if (ohlcFromRedis != null) {
      return ohlcFromRedis;
    }
    String url = UrlBuilder.get(Scheme.HTTP, domain + ":" + port, endpoint);
    System.out.println("url=" + url);
    OHLCDTO ohlcdto = restTemplate.getForObject(url, OHLCDTO.class);
    System.out.println("ohlcdto=" + ohlcdto);
    OHLCDTO.Chart.Result.Indicator.Quote quote =
        ohlcdto.getChart().getResults()[0].getIndicator().getQuotes()[0];

    // Assume all lengths matchs each others
    Long[] dateTime = ohlcdto.getChart().getResults()[0].getTimestamps();
    Long[] volumes = quote.getVolumes();
    Double[] opens = quote.getOpens();
    Double[] highs = quote.getHighs();
    Double[] lows = quote.getLows();
    Double[] closes = quote.getCloses();

    // Skip Database if result lengths do not match
    if (dateTime.length != volumes.length //
        || volumes.length != opens.length //
        || opens.length != highs.length //
        || highs.length != lows.length //
        || lows.length != closes.length) {
      return ohlcdto;
    }

    for (int i = 0; i < dateTime.length; i++) {
      StockDailyEntity stockDailyEntity = StockDailyEntity.builder() //
          .datetime(dateTimeManager.getLocalDateTime(dateTime[i])) //
          .open(opens[i]) //
          .high(highs[i]) //
          .low(lows[i]) //
          .close(closes[i]) //
          .volume(volumes[i]) //
          .build();
      stockDailyRepository.save(stockDailyEntity);
    }
    // set to redis
    this.setOHLCToRedis(ohlcdto);
    return ohlcdto;
  }
}
