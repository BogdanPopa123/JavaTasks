package com.company;

public class Item {

    private String itemcode;
    private int price;

    public Item(String itemcode, int price){
        this.itemcode = itemcode;
        this.price = price;
    }

    public String getItemcode(){
        return itemcode;
    }

    public int getPrice(){
        return  price;
    }

}
