/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fawryrisejourney;

import java.util.List;

/**
 *
 * @author menna
 */
public class FawryRiseJourney {
        
    public static void main(String[] args) {
        
        ShippableProduct TV = new ShippableProduct ("TV",5000 , 4, 5.0 );
        ShippableProduct laptop = new ShippableProduct ("laptop",20000, 4, 3.0 );
        ShippableProduct microwave = new ShippableProduct ("microwave",15000, 4, 10.0 );
        
        Cart cart = new Cart();
        cart.add(TV, 2);         
        cart.add(laptop, 1);      
        cart.add(microwave, 1);             
        
        Customer customer = new Customer("Menna", 100000);


        List<ShippableProduct> itemsToShip = cart.getShippableItems();

        
        ShippingService.ship(itemsToShip);
        CheckoutService.checkout(customer, cart);

         

    }
}
