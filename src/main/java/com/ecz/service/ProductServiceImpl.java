package com.ecz.service;

import com.ecz.model.Product;
import com.ecz.repository.ProductRepository;
import com.ecz.repository.ProductRepositoryCollectionImpl;
import com.ecz.repository.ProductRepositoryDatabaseImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
//    ProductRepository productRepositoryCollectionImpl=new ProductRepositoryCollectionImpl();
    ProductRepository productRepositoryDatebaseImpl=new ProductRepositoryDatabaseImpl();
    public void addProduct(Product product){
//        productRepositoryCollectionImpl.addProduct(product);
        productRepositoryDatebaseImpl.addProduct(product);
    }
    public List<Product> displayProduct(){
        return productRepositoryDatebaseImpl.displayProduct();
    }
    public boolean searchProduct(int productId){
        return productRepositoryDatebaseImpl.searchProduct(productId);
    }
    public void updateProduct(int productId){
        productRepositoryDatebaseImpl.updateProduct(productId);
    }
    public void deleteProduct(int productId){
        productRepositoryDatebaseImpl.deleteProduct(productId);
    }
}
