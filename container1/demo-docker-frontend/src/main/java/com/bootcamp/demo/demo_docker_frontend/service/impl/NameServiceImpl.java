package com.bootcamp.demo.demo_docker_frontend.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_docker_frontend.infra.Scheme;
import com.bootcamp.demo.demo_docker_frontend.infra.UrlBuilder;
import com.bootcamp.demo.demo_docker_frontend.service.NameService;

@Service
public class NameServiceImpl implements NameService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.demo-docker-backend.domain}")
  private String domain;

  @Value("${api.demo-docker-backend.port}")
  private String port;

  @Value("${api.demo-docker-backend.names.endpoint}")
  private String endpoint;

  @Override
  public List<String> names() {
    String url = UrlBuilder.get(Scheme.HTTP, domain + ":" + port, endpoint);
    System.out.println("url=" + url);
    return Arrays.asList(restTemplate.getForObject(url, String[].class));
  }
}
