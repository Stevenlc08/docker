package com.bootcamp.demo.demo_docker_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_docker_backend.model.dto.OHLCDTO;

public interface StockOperation {
  @GetMapping(value = "/ohlc")
  OHLCDTO getOHLC();
}
