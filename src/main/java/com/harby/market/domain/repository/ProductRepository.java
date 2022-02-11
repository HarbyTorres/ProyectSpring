package com.harby.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.harby.market.domain.Product;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<List<Product>> getByName (String name);
    List<Product> getByActive (boolean active);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
