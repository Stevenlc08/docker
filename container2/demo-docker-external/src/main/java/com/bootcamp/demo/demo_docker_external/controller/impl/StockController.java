package com.bootcamp.demo.demo_docker_external.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_docker_external.controller.StockOperation;
import com.bootcamp.demo.demo_docker_external.model.dto.OHLCDTO;
import com.bootcamp.demo.demo_docker_external.service.OHLCService;

@RestController
public class StockController implements StockOperation {
  @Autowired
  private OHLCService ohlcService;

  @Override
  public OHLCDTO getOHLC() {
    return ohlcService.getOHLC();
  }
}