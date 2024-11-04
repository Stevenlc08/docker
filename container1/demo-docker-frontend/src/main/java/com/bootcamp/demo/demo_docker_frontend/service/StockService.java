package com.bootcamp.demo.demo_docker_frontend.service;

import com.bootcamp.demo.demo_docker_frontend.model.dto.OHLCDTO;

public interface StockService {
  OHLCDTO getOHLC();
}
