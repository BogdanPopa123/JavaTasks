package com.company;

public class Test {

    private String s;

    public Test(){
    }

    public Test(String s) {
        this.s = s;
    }

    public void ShowString(){
        System.out.println("The string is : " + s);
    }

    public void ShowInt(int n){
        System.out.println("The number is : " + n);
    }

    private void Priv(){
        System.out.println("Private method invoked");
    }



}
