package com.aushadhisetu.repository;

import com.aushadhisetu.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByKendraId(Long kendraId);


    List<Stock> findByKendraIdAndQuantityLessThan(Long kendraId, int i);
}