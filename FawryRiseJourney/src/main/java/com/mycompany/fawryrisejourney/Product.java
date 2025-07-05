/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryrisejourney;

/**
 *
 * @author menna
 */
abstract public class Product {
    private String name; 
    private double price;
    private int quantity;
    
    public Product( String name,double price , int quantity ){
        this.name = name; 
        this.price = price;
        this.quantity = quantity;
    }
    
    public boolean isExpired(){
        return false;  //default value is false
    }
    
    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Cannot reduce more than available stock");
        }
        quantity -= amount;
    }

    
}
