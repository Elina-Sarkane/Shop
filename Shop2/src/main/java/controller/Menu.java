package controller;

import entity.Product;
import entity.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();

    public void showMenu(){
        String userInput = "";
        do{
            System.out.println("\nPlease choose activity: ");

            System.out.println("1. Log in");
            System.out.println("2. View all products");
            System.out.println("3. View one product");
            System.out.println("4. Buy products");

            System.out.print("Enter your choice: ");
            userInput = scanner.nextLine();

            switch (userInput){
                case "quit":
                    System.out.println("Exiting application!");
                    break;
                case "1":
                    addUser();
                    break;
                case "2":
                    viewAllProducts();
                    break;
                case "3":
                    viewSingleProduct();
                    break;
                case "4":
                    buyProducts();
                    break;
            }
            System.out.print("\nEnter C to continue\n");
            scanner.nextLine();

        }while (!userInput.equalsIgnoreCase("quit"));

        return;
    }
    void addUser() {
        User user = new User("ella@mail.com", "Ella", 50f);
        User user1 = new User("john@mail.com", "John", 10f);
        User user2 = new User("anna@mail.com", "Anna", 30f);

        String userInput = "";
        do{
            System.out.println("\n Log in ");
            System.out.print("Enter email: ");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "ella@mail.com":
                    System.out.println("Welcome to the shop " + user.userName + ".\nYour current balance is " + user.userBalance + " euros.");
                    showMenu();
                    break;
                case "john@mail.com":
                    System.out.println("Welcome to the shop " + user1.userName + ".\nYour current balance is " + user1.userBalance + " euros.");
                    showMenu();
                    break;
                case "anna@mail.com":
                    System.out.println("Welcome to the shop " + user2.userName + ".\nYour current balance is " + user2.userBalance + " euros.");
                    showMenu();
                    break;
                default:
                    System.out.println("User not found");
                    showMenu();
            }
        }while (!userInput.equalsIgnoreCase(""));
    }
    void viewAllProducts() {
        ArrayList<Product> allProducts = shop.getAllProducts();
        System.out.println("Id\t Product Name\t Available Amount\t\t  Price");

        int counter = 0;
        for (Product product : allProducts) {
            System.out.println(counter + ".  \t" + product.productName + " \t\t\t\t" + product.availableProductNumber + "\t\t\t\t" + product.productPrice + " euros.");
            counter++;
        }
    }
    void viewSingleProduct(){
            System.out.println("\n View product");
            System.out.println("Enter product ID: ");

            int productId = scanner.nextInt();
            Product product = shop.getSingleProduct(productId);

            System.out.println("Product Name: " + product.productName);
            System.out.println("Available amount: " + product.availableProductNumber);
            System.out.println("Product Price: " + product.productPrice + " euros.");
        }
    public void buyProducts() {
        Product product = new Product("Apples", 3, 0.50f);
        Product product1 = new Product("Bread", 2, 0.70f);
        Product product2 = new Product("Milk", 4, 1.80f);
        Product product3 = new Product("Cake", 5, 3.50f);
        Product product4 = new Product("Tea", 1, 2.50f);
        String productInput = "";
        do{
            System.out.print("Enter product: ");
            productInput = scanner.nextLine();
            switch (productInput) {
                case "quit":
                    System.out.println("Exiting shopping!");
                case "Apples":
                    System.out.println("How many " + product.productName + " do you want?");
                    System.out.print("Product price is " + product.productPrice*scanner.nextFloat() + " euros.");
                    showMenu();
                    break;
                case "Bread":
                    System.out.println("How many " + product1.productName + " do you want?");
                    System.out.print("Product price is " + product1.productPrice*scanner.nextFloat() + " euros.");
                    showMenu();
                    break;
                case "Milk":
                    System.out.println("How many " + product2.productName + " do you want?");
                    System.out.print("Product price is " + product2.productPrice*scanner.nextFloat() + " euros.");
                    showMenu();
                    break;
                case "Cake":
                    System.out.println("How many " + product3.productName + " do you want?");
                    System.out.print("Product price is " + product3.productPrice*scanner.nextFloat() + " euros.");
                    showMenu();
                    break;
                case "Tea":
                    System.out.println("How many " + product4.productName + " do you want?");
                    System.out.print("Product price is " + product4.productPrice*scanner.nextFloat() + " euros.");
                    showMenu();
                    break;
                default:
                    System.out.println("Product not found");
            }
            System.out.print("\nEnter C to continue\n");
            scanner.nextLine();

        }while (!productInput.equalsIgnoreCase("quit"));

        return;
    }
}
