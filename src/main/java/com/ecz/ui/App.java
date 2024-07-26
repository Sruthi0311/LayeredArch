package com.ecz.ui;

import com.ecz.model.Product;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username");
        String username=sc.nextLine();
        System.out.println("enter password");
        String password=sc.nextLine();
        if(username.equals("Sruthi")&&password.equals("sruthi@514")){
            System.out.println("Login success");
            System.out.println("Welcome to E-Commerce Application");
            Menu menu=new Menu();
            menu.displayMenu();
            System.out.println("Enter choice from above display");
            int choice=menu.getChoice();
            while(choice>=1&&choice<=5){
                switch(choice){
                    case 1:
                        menu.addProduct(menu.getProduct());
                        break;
                    case 2:
                        menu.displayProduct();
                        break;
                    case 3:
                        menu.searchProduct();
                        break;
                    case 4:
                        menu.updateProduct();
                        break;
                    case 5:
                        menu.deleteProduct();
                        break;
                    default:
                        break;
                }
                menu.displayMenu();
                System.out.println("Enter choice from above display");
                choice=menu.getChoice();
            }
        }
        else{
            System.out.println("login unsuccessful");
        }
    }
}
