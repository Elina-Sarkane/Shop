package controller;

import entity.Product;
import entity.User;

import java.util.ArrayList;

public class Shop {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Product> products = new ArrayList<Product>();

    public ArrayList<User> getUser(){
        users.add(new User("ella@mail.com", "Ella", 50f));
        users.add(new User("john@mail.com", "John", 10f));
        users.add(new User("anna@mail.com", "Anna", 30f));
        return users;
    }
    /*public String addUser(User user){
        this.users.add(user);
        return "Hello " + user.userName + ".";
    }*/

   // public Product addProducts(String productName){
        //return this.products.add(productName);
        //return product.productName + " added";
    //}
    public ArrayList<Product> getAllProducts(){
        products.add(new Product("Apples", 3, 0.50f));
        products.add(new Product("Bread", 2, 0.70f));
        products.add(new Product("Milk", 4, 1.80f));
        products.add(new Product("Cake", 5, 2.50f));
        products.add(new Product("Tea", 1, 3.50f));
        return products;
    }
    public Product getSingleProduct(int productId){
        return this.products.get(productId);
    }

    public Product sellProduct(int productId){
        return this.products.get(productId);
    }

}
