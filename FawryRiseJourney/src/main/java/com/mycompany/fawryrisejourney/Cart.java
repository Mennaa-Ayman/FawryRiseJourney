/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryrisejourney;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author menna
 */
public class Cart {
    List <CartItem> items;
  
    public Cart(){
        items = new ArrayList<>();
    }
    public void add(Product product, int quantity){
        if(quantity <=0) {
            throw new IllegalArgumentException("Quantity entered is not a valid number");
        }
        if (quantity > product.getQuantity()){
            throw new IllegalArgumentException("There is not enough stock available");
        }
        items.add(new CartItem(product, quantity));    
    }
    
    public boolean isEmpty(){
        return items.isEmpty();   
    }

    public List<CartItem> getItems() {
        return items;
    }

    public List<ShippableProduct> getShippableItems() {
       List<ShippableProduct> shippables = new ArrayList<>();  // shippable items list
       for(CartItem item : items){
           if (item.isShippable()){
               Product product = item.getProduct();  // get the product
               ShippableProduct shippableProduct = (ShippableProduct) product;
               for (int i=0 ; i< item.getQuantity(); i++){
               shippables.add(shippableProduct);
           }
           }
       }
       return shippables;
}
}

class CartItem{
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public boolean isShippable(){
        return product instanceof ShippableProduct;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
    public double getTotalPrice(){
        return product.getPrice()*quantity;
    }
    
    
   

}
