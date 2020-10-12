package com.mk.repository;

import com.mk.data.entities.OrderBook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
    
}