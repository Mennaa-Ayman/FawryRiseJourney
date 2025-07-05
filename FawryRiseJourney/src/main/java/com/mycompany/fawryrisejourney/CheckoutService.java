/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryrisejourney;

/**
 *
 * @author menna
 */
import java.util.List;

public class CheckoutService {
    private static final double shipping_fee = 30.0;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println(" Error: Cart is empty.");
            return;
        }

        List<CartItem> items = cart.getItems();
        double subtotal = 0;
        double totalWeight = 0;

   
        for (CartItem item : items) {
            Product product = item.getProduct();

            // Validate quantity
            if (item.getQuantity() > product.getQuantity()) {
                System.out.println("Sorry, there is no enough stock for " + product.getName());
                return;
            }

            // Validate expiry
            if (product instanceof ExpirableProduct) {
                ExpirableProduct exp = (ExpirableProduct) product;
                if (exp.isExpired()) {
                    System.out.println(" Product " + product.getName() + " is expired.");
                    return;
                }
            }

            subtotal += item.getTotalPrice();

            // Collect weight if shippable
            if (item.isShippable()) {
                ShippableProduct shippable = (ShippableProduct) product;
                totalWeight += shippable.getWeight() * item.getQuantity();
            }
        }

        // Flat shipping fee if there's anything to ship
        double shippingFee = totalWeight > 0 ? shipping_fee : 0;
        double totalAmount = subtotal + shippingFee;

        if (totalAmount > customer.getBalance()) {
            System.out.println("❌ Error: Insufficient balance.");
            return;
        }

        // Deduct product quantities
        for (CartItem item : items) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Deduct from customer's balance
        customer.deductBalance(totalAmount);

        // Handle shipping
        List<ShippableProduct> shippableItems = cart.getShippableItems();
        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        // Print receipt
        System.out.println("============ Checkout receipt =================");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x   " + item.getProduct().getName() + "\t" + item.getTotalPrice() + "LE");
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.2f\n", subtotal);
        System.out.printf("Shipping\t%.2f\n", shippingFee);
        System.out.printf("Amount\t\t%.2f\n", totalAmount);
        System.out.printf("Balance\t\t%.2f\n", customer.getBalance());
    }
}
