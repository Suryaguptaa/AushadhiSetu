package com.aushadhisetu.service;


import com.aushadhisetu.entity.Stock;
import com.aushadhisetu.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;


    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public Stock updateStock(Long stockId, int newQuantity){

        Stock stock = stockRepository.findById(stockId)
                .orElse(null);

        if (stock == null) return null;

        stock.setQuantity(newQuantity);
        stock.setAvailable(newQuantity > 0);
        stock.setLastUpdated(LocalDateTime.now());

        return stockRepository.save(stock);
    }

    @Transactional(readOnly = true)
    public List<Stock> getStockByKendra(Long kendraId) {
        return stockRepository.findByKendraId(kendraId);
    }

    @Transactional(readOnly = true)
    public List<Stock> getLowStock(Long kendraId) {
        return stockRepository.findByKendraIdAndQuantityLessThan(kendraId, 10);
    }

    @Transactional
    public Stock addStock(Stock stock) {

        stock.setLastUpdated(LocalDateTime.now());
        stock.setAvailable(stock.getQuantity() > 0);

        return stockRepository.save(stock);
    }
}