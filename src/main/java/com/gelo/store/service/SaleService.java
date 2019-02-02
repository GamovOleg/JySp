package com.gelo.store.service;


import org.springframework.stereotype.Service;

@Service
public interface SaleService {
    void processSale(String articleId, int quantity);
}
