package com.bootcamp.demo.demo_docker_backend.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_docker_backend.controller.StockOperation;
import com.bootcamp.demo.demo_docker_backend.model.dto.OHLCDTO;
import com.bootcamp.demo.demo_docker_backend.service.StockService;

@RestController
public class StockController implements StockOperation {
  @Autowired
  private StockService stockService;

  @Override
  public OHLCDTO getOHLC() {
    return stockService.getOHLC();
  }
}
