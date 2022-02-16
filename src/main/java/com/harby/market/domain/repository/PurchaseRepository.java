package com.harby.market.domain.repository;

import com.harby.market.domain.Purchase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Optional<List<Purchase>> getByDate(LocalDateTime date);
    Optional<List<Purchase>> getByState(String state);
    Purchase save(Purchase purchase);
}
