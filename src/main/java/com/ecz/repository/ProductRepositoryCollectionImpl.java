package com.ecz.repository;

import com.ecz.exception.DuplicateProductException;
import com.ecz.exception.ProductNotFoundException;
import com.ecz.model.Product;

import java.util.*;

public class ProductRepositoryCollectionImpl implements ProductRepository {
    Scanner sc=new Scanner(System.in);
    Map<Integer,Product> productMap=new HashMap<>();
    public void addProduct(Product product){
        try{
            if(productMap.containsKey(product.getProductId())){
                throw new DuplicateProductException("Product already exists");
            }
            productMap.put(product.getProductId(),product);
        }
        catch(DuplicateProductException duplicateProductException){
            System.out.println(duplicateProductException.getMessage());
        }
    }
    public List<Product> displayProduct(){
        List<Product> productList=new ArrayList<>();
        for(Map.Entry<Integer,Product> productMapEntry:productMap.entrySet()){
            productList.add(productMapEntry.getValue());
        }
        return  productList;
    }
    public boolean searchProduct(int productId){
        boolean productFound=false;
        try{
            if(productMap.containsKey(productId)){
                productFound=true;
            }
            throw new ProductNotFoundException("Product not exists");
        }
        catch(ProductNotFoundException productNotFoundException){
            System.out.println(productNotFoundException.getMessage());
        }
        return productFound;
    }
    public void updateProduct(int productId){
        try{
            if(productMap.containsKey(productId)){
                Product product=productMap.get(productId);
                System.out.println("1. update productName");
                System.out.println("2. update productPrice");
                System.out.println("3. update productQuantity");
                System.out.println("4. update productIsAvailable");
                System.out.println("other values will exit");
                System.out.println("Enter choice to update");
                int choice=sc.nextInt();
                while(choice>=1&&choice<=4){
                    switch(choice){
                        case 1:
                            sc.nextLine();
                            System.out.println("Enter productName to update");
                            product.setProductName(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Enter productPrice to update");
                            product.setPrice(sc.nextDouble());
                            break;
                        case 3:
                            System.out.println("Enter productQuantity to update");
                            product.setQuantity(sc.nextInt());
                            break;
                        case 4:
                            System.out.println("Enter productIsAvailable to update");
                            product.setIsAvailable(sc.nextBoolean());
                            break;
                        default:
                            break;
                    }
                    System.out.println("Enter choice to update");
                    choice= sc.nextInt();
                }
                productMap.put(productId,product);
            }
            throw new ProductNotFoundException("Product not exists");
        }
        catch(ProductNotFoundException productNotFoundException){
            System.out.println(productNotFoundException.getMessage());
        }
    }
    public void deleteProduct(int productId){
        try{
            if(productMap.containsKey(productId)){
                productMap.remove(productId);
            }
            throw new ProductNotFoundException("Product not exists");
        }
        catch(ProductNotFoundException productNotFoundException){
            System.out.println(productNotFoundException.getMessage());
        }
    }
}
