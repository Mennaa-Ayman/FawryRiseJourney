/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryrisejourney;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author menna
 */
public class ShippingService {
    
    public static void ship(List <ShippableProduct> items){
        if (items.isEmpty()){
            System.out.println("No items to be shipped");
        }
        Map<String, ItemSummary> summaryMap = new HashMap<>();
        double totalWeight = 0;

        for (ShippableProduct product : items) {
            totalWeight += product.getWeight();

            summaryMap.putIfAbsent(product.getName(), new ItemSummary(0, product.getWeight()));
            ItemSummary item = summaryMap.get(product.getName());
            item.count++;
        }

        for (Map.Entry<String, ItemSummary> entry : summaryMap.entrySet()) {
            String name = entry.getKey();
            ItemSummary item = entry.getValue();
            double totalItemWeight = item.count * item.weight;

        System.out.println(item.count + "x " + name + "\t" + totalItemWeight + "kg");
        }

        System.out.printf("Total package weight %.2fkg\n", totalWeight);
    }

    
    private static class ItemSummary{
        int count; 
        double weight;
    
    ItemSummary(int count, double weight){
        this.count = count;
        this.weight = weight; 
    }   
    
}
}
