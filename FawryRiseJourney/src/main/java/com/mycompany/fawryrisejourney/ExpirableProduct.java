/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryrisejourney;

import java.time.LocalDate;

/**
 *
 * @author menna
 */
public class ExpirableProduct extends Product {
    private LocalDate expiryDate;
    
    ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate){
        super (name, price, quantity);
        this.expiryDate = expiryDate;    
    }
      
    @Override
    public boolean isExpired(){
        return expiryDate.isBefore(LocalDate.now());
    }
}
