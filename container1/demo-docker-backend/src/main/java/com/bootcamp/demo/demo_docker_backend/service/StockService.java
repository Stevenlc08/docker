package com.bootcamp.demo.demo_docker_backend.service;

import com.bootcamp.demo.demo_docker_backend.model.dto.OHLCDTO;

public interface StockService {
  OHLCDTO getOHLC();
}
