package com.bootcamp.demo.demo_docker_backend.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "Stock_Daily")
@Getter
@AllArgsConstructor
@Builder
public class StockDailyEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  private LocalDateTime datetime;
  private Double open;
  private Double high;
  private Double low;
  private Double close;
  private Long volume;
}
