package entity;

import java.util.UUID;

public class Product {
    public UUID productId;
    public String productName;
    public int availableProductNumber;
    public float productPrice;


    public Product(String productName, int availableProductNumber, float productPrice) {
        this.productName = productName;
        this.availableProductNumber = availableProductNumber;
        this.productPrice = productPrice;
    }
}

