package controller;

import entity.Product;
import entity.User;
import types.UserType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();

    public void showHomeScreen() {
        String option = "";

        System.out.println("Welcome to the shop!"
                + "\n1. Add user \t\t 4. Add product"
                + "\n2. View users \t\t 5. View products"
                + "\n3. Remove user \t\t 6. Buy products"
                + "\n7. Exit shop"
        );
        System.out.print("Choose option: ");
        option = scanner.nextLine();

        switch (option) {
            case "1":
                collectUserInfoAndAddUser();
                break;
            case "2":
                showAllUsers();
                break;
            case "3":
                deleteUser();
                break;
            case "4":
                collectProductInfoAndCreate();
                break;
            case "5":
                showAllProducts();
                break;
            case "6":
                sellProductToUser();
                break;
            case "7":
                System.out.println("Exiting shop!");
                return;
            default:
                break;
        }
        System.out.print("\nPress 0 to continue\n");
        scanner.nextLine();

        this.showHomeScreen();
    }

    private void collectUserInfoAndAddUser() {
        System.out.println("Enter User Name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter User Email: ");
        String userEmail = scanner.nextLine();
        System.out.println("Enter balance e.g 10.50: ");
        float balance = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter User type (owner / buyer): ");
        UserType type = (scanner.nextLine().trim().toUpperCase().equals("OWNER"))
                ? UserType.OWNER : UserType.BUYER;

        LocalDate createdAt = LocalDate.now();

        User user = new User(userName, userEmail, balance, type, createdAt);
        System.out.println(shop.createUser(user));
    }

    private void showAllUsers() {
        ArrayList<User> users = shop.getUsers();
        int counter = 0;
        for (User currentUser : users) {
            System.out.println(counter + ". \t" + currentUser.getUserName() +
                    " | " + currentUser.getUserEmail() +
                    " | " + currentUser.getBalance() + " euros" +
                    " | " + currentUser.getType() +
                    " | " + currentUser.getCreatedAt());
            counter++;
        }
    }

    private void deleteUser() {
        System.out.println("Remove user\n");
        System.out.println("Enter user ID: ");

        int userId = scanner.nextInt();
        String message = shop.removeUser(userId);
        System.out.println(message);

    }

    private void collectProductInfoAndCreate() {
        Product product = new Product();
        System.out.println("Enter product Name: ");
        product.setName(scanner.nextLine());

        System.out.println("Product price e.g 10.50:");
        product.setPrice(Float.parseFloat(scanner.nextLine()));

        System.out.println("Enter Product quantity: ");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));

        product.setId(UUID.randomUUID());
        product.setCreatedAt(LocalDate.now());

        System.out.println(shop.createProduct(product));
    }

    private void showAllProducts() {
        ArrayList<Product> products = shop.getAllProduct();
        System.out.println("\n All available products\n");
        int counter = 0;
        for (Product currentProduct : products) {
            System.out.println(counter + ". \t" + currentProduct.getId() +
                    " | " + currentProduct.getName() +
                    " | " + currentProduct.getPrice() + " euros" +
                    " | " + currentProduct.getQuantity() + " pcs" +
                    " | " + currentProduct.getCreatedAt());
            counter++;
        }
    }

    private void sellProductToUser() {
        System.out.println("Enter your email address: ");
        String userEmail = scanner.nextLine();

        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("How many items: ");
        Integer numberOfItems = Integer.parseInt(scanner.nextLine());

        System.out.println(shop.buyProduct(productName, userEmail, numberOfItems));

    }
}

