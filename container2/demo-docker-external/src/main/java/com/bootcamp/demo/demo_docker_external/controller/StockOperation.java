package com.bootcamp.demo.demo_docker_external.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_docker_external.model.dto.OHLCDTO;

public interface StockOperation {
  @GetMapping(value = "/ohlc")
  OHLCDTO getOHLC();
}