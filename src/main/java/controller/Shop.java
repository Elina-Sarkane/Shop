package controller;

import entity.Product;
import entity.User;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<User> users = new ArrayList<User>();

    public String createUser(User newUser){
        users.add(newUser);
        return "User created successfully";
    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public User getSingleUser(int userId){
        return this.users.get(userId);

    }
    //public User reduceBalance(int getBalance){
      //  return this.users.get(getBalance);
    //}
    public String removeUser(int userId){
        try {
            users.remove(userId);
        }catch (Exception ex){
            return "Unable to remove user";
        }
        return "User removed successfully!";
    }
    public String createProduct(Product product){
        products.add(product);
        return "Product added successfully";
    }
    public ArrayList<Product> getAllProduct(){
        return products;
    }


    public String buyProduct(String productName, String userEmail, Integer numberOfProduct){
        Product productToSell = findProductByName(productName);
        if (productToSell == null){ return "Product not found";}
        if (productToSell.getQuantity() < numberOfProduct) {return "Not enough items to buy";}

        User buyer = findUserByEmail(userEmail);
        if (buyer == null) { return "User not found";}

        float buyerBalance = buyer.getBalance();
        float totalCostOfPurchase = productToSell.getPrice() * numberOfProduct;

        if (buyerBalance < totalCostOfPurchase){return "Not enough balance on users account!";}

        //users old balance - total cost of purchase
        buyer.setBalance(buyerBalance - totalCostOfPurchase);
        productToSell.setQuantity(productToSell.getQuantity() - numberOfProduct);

        updateUser(buyer);
        updateProduct(productToSell);
        return "Product purchased successfully";
    }
    private Product findProductByName(String productName){
        for (Product currentProduct: this.products){
            if(currentProduct.getName().toLowerCase().equals(productName.toLowerCase())){
                return currentProduct;
            }
        }
        return null;
    }
    private User findUserByEmail(String userEmail){
        for (User currentUser: this.users){
            if(currentUser.getUserEmail().toLowerCase().equals(userEmail.toLowerCase())){
                return currentUser;
            }
        }
        return null;
    }

    private void updateUser(User userToUpdate){
        for (User currentUser: this.users){
            if(currentUser.getId().equals(userToUpdate.getId())){
                currentUser.setBalance(userToUpdate.getBalance());
            }
        }
    }
    private void updateProduct(Product productToUpdate){
        for (Product currentProduct: this.products){
            if(currentProduct.getId().equals(productToUpdate.getId())){
                currentProduct.setQuantity(productToUpdate.getQuantity());
            }
        }
    }

}
