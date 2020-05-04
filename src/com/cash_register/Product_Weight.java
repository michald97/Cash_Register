package com.cash_register;

public class Product_Weight extends Product {

    private float weight;

    public Product_Weight(String name,double price ) {
        super(name,price);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

}
