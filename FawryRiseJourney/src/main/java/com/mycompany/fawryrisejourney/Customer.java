/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryrisejourney;

/**
 *
 * @author menna
 */
public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    public double getBalance(){
    return balance;
    }
    
    public void deductBalance(double amount) {
        this.balance -= amount;
    }

    // Optional: Add money to balance
    public void addBalance(double amount) {
        this.balance += amount;
    }

    public String getName() {
        return name;
    }
}

