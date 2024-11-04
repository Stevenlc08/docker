package com.bootcamp.demo.demo_docker_backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public interface NameOperation {
  @GetMapping(value = "/names")
  List<String> getAll();
}
