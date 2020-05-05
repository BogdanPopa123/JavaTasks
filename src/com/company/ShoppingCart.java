package com.company;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items;

    public ShoppingCart(){
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal(){
        int sum = 0;
        for(Item item : items){
            sum = sum + item.getPrice();
        }
        return sum;
    }

    public void pay(PaymenyStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }

}
