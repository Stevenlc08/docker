package com.bootcamp.demo.demo_docker_backend.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_docker_backend.controller.NameOperation;
import com.bootcamp.demo.demo_docker_backend.service.NameService;

@RestController
public class NameController implements NameOperation {
  @Autowired
  private NameService nameService;

  @Override
  public List<String> getAll() {
    return nameService.findAll();
  }
}
