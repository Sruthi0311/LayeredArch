package com.ecz.ui;

import com.ecz.model.Product;
import com.ecz.service.ProductService;
import com.ecz.service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Menu {
    ProductService productServiceImpl=new ProductServiceImpl();
    Scanner sc=new Scanner(System.in);
    public void displayMenu(){
        System.out.println("1. Add product");
        System.out.println("2. Display product");
        System.out.println("3. search product");
        System.out.println("4. update product");
        System.out.println("5. delete product");
        System.out.println("other values will exit");
    }
    public int getChoice(){
        return sc.nextInt();
    }
    public Product getProduct(){
        System.out.println("Enter Product id");
        int productId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Product Name");
        String productName=sc.nextLine();
        System.out.println("Enter Product Price");
        double productPrice=sc.nextDouble();
        System.out.println("Enter Product quantity");
        int productQuantity=sc.nextInt();
        System.out.println("Enter Product is Available or not");
        boolean productIsAvailable=sc.nextBoolean();
        return new Product(productId,productName,productPrice,productQuantity,productIsAvailable);
    }
    public void addProduct(Product product){
        productServiceImpl.addProduct(product);
    }
    public void displayProduct(){
        List<Product> productList=productServiceImpl.displayProduct();
        for(Product product:productList){
            System.out.println(product);
        }
    }
    public void searchProduct(){
        System.out.println("Enter productId for search");
        boolean productFound=productServiceImpl.searchProduct(sc.nextInt());
        if(productFound){
            System.out.println("Prouduct Found");
        }
        else{
            System.out.println("Product Not Found");
        }
    }
    public void updateProduct(){
        System.out.println("Enter productId for update");
        productServiceImpl.updateProduct(sc.nextInt());
    }
    public void deleteProduct(){
        System.out.println("Enter productId for delete");
        productServiceImpl.deleteProduct(sc.nextInt());
    }
}
