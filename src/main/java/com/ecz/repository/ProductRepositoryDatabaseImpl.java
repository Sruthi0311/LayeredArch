package com.ecz.repository;

import com.ecz.exception.DuplicateProductException;
import com.ecz.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepositoryDatabaseImpl implements ProductRepository {
    Scanner sc=new Scanner(System.in);
    public void addProduct(Product product){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","mysql");
            System.out.println("Connection established");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into product values(?,?,?,?,?);");
            preparedStatement.setInt(1,product.getProductId());
            preparedStatement.setString(2,product.getProductName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setBoolean(5,product.getIsAvailable());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            try{
                if(sqlException.getErrorCode()==1062){
                    throw new DuplicateProductException("PrimaryKey already exists");
                }
            }
            catch (DuplicateProductException duplicateProductException){
                System.out.println(duplicateProductException.getMessage());
            }
            System.out.println(sqlException.getMessage());
        }
    }
    public List<Product> displayProduct(){
        List<Product> productList=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from product");
            while(resultSet.next()){
                Product product=new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4),resultSet.getBoolean(5));
                productList.add(product);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return productList;
    }
    public boolean searchProduct(int productId){
        boolean productFound=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from product where productId="+productId);
            while(resultSet.next()){
                productFound=true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return productFound;
    }
    public void updateProduct(int productId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            String query="update product set ";
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
                        query+="productName=";
                        System.out.println("Enter productName to update");
                        query+=("\'"+sc.nextLine()+"\'");
                        break;
                    case 2:
                        query+="productPrice=";
                        System.out.println("Enter productPrice to update");
                        query+=sc.nextDouble();
                        break;
                    case 3:
                        query+="productQuantity=";
                        System.out.println("Enter productQuantity to update");
                        query+=sc.nextInt();
                        break;
                    case 4:
                        query+="productIsAvailable=";
                        System.out.println("Enter productIsAvailable to update");
                        query+=sc.nextBoolean();
                        break;
                    default:
                        break;
                }
                System.out.println("Enter choice to update");
                choice= sc.nextInt();
                if(choice>=1&&choice<=4) query+=" , ";
            }
            query+=("where productId="+productId);
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public void deleteProduct(int productId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            statement.executeUpdate("delete from product where productId="+productId);
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
}
