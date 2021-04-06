package entity;

import types.UserType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID userId;
    private String userName;
    private String userEmail;
    private float balance;
    private UserType type;
    private LocalDate createdAt;

    public User(String userName, String userEmail, float balance, UserType type, LocalDate createdAt) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.balance = balance;
        this.type = type;
        this.createdAt = createdAt;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public float getBalance() {
        return balance;
    }
    public UserType getType() {
        return type;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
