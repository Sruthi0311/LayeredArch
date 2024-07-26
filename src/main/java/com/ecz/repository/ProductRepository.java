package com.ecz.repository;

import com.ecz.model.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);
    List<Product> displayProduct();
    boolean searchProduct(int productId);
    void updateProduct(int productId);
    void deleteProduct(int productId);
}
