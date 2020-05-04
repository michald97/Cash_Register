package com.cash_register;

public class Product {

    private double price;
    private String name;
    private int units;

    public Product(String name,double price ) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(double price) {this.price = price;}
    public double getPrice() {return price;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }

}
