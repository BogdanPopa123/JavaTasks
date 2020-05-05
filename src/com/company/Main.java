package com.company;

public class Main {

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item("1223", 100);
        Item item2 = new Item("521", 75);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        shoppingCart.pay(new PaypalStrategy("bogdan@gmail.com", "parola"));

        shoppingCart.pay(new CreditCardStrategy("Bogdan", "123", "0000", "5/2/2021"));

    }
}
