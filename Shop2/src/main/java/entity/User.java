package entity;

import java.util.ArrayList;

public class User {
    public String userName;
    public String userEmail;
    public float userBalance;

    public User(String userEmail, String userName, float userBalance) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userBalance = userBalance;
    }
}
