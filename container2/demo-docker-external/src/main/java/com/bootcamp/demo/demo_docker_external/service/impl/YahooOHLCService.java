package com.bootcamp.demo.demo_docker_external.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_docker_external.infra.Scheme;
import com.bootcamp.demo.demo_docker_external.infra.UrlBuilder;
import com.bootcamp.demo.demo_docker_external.model.dto.OHLCDTO;
import com.bootcamp.demo.demo_docker_external.service.OHLCService;

@Service
public class YahooOHLCService implements OHLCService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.yahoo-finance.domain}")
  private String domain;

  @Value("${api.yahoo-finance.ohlc.base-path}")
  private String basePath;

  @Value("${api.yahoo-finance.ohlc.endpoint}")
  private String endpoint;

  @Override
  public OHLCDTO getOHLC() {
    String url =
        UrlBuilder.get(Scheme.HTTPS, domain, endpoint, new String[] {basePath});
    System.out.println("url=" + url);
    OHLCDTO ohlcdto = restTemplate.getForObject(url, OHLCDTO.class);
    System.out.println("ohlcdto=" + ohlcdto);
    return ohlcdto;
  }
}
