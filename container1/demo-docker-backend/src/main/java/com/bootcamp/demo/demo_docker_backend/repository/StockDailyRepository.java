package com.bootcamp.demo.demo_docker_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_docker_backend.entity.StockDailyEntity;

@Repository
public interface StockDailyRepository extends JpaRepository<StockDailyEntity, Long> {
  
}
