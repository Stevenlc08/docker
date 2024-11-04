package com.bootcamp.demo.demo_docker_backend.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_docker_backend.service.NameService;

@Service
public class NameServiceImpl implements NameService {
  @Override
  public List<String> findAll() {
    return Arrays.asList("Vincent", "Kary", "Jenny");
  }
}
