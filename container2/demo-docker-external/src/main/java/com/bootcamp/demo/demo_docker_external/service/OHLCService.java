package com.bootcamp.demo.demo_docker_external.service;

import java.time.LocalDate;
import com.bootcamp.demo.demo_docker_external.model.dto.OHLCDTO;

public interface OHLCService {
  // public OHLCDTO getOHLC(LocalDate startDate, LocalDate endDate);
  public OHLCDTO getOHLC();
}
