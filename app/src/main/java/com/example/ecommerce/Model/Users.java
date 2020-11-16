package com.example.ecommerce.Model;

public class Users
{
    private String name, username, password;

    public  Users()
    {

    }

    public Users(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
