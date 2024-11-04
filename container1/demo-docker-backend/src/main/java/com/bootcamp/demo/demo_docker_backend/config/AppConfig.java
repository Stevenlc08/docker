package com.bootcamp.demo.demo_docker_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_docker_backend.infra.RedisHelper;
import com.bootcamp.demo.demo_docker_backend.infra.time.DateTimeManager;
import com.bootcamp.demo.demo_docker_backend.infra.time.UNIX;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  DateTimeManager dateTimeManager() {
    return new DateTimeManager(UNIX.TO_HONG_KONG);
  }

  @Bean
  ObjectMapper objectMapper() {
    // set states for object mapper
    return new ObjectMapper();
  }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisHelper(factory, objectMapper);
  }

}
