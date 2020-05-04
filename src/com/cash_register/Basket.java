package com.cash_register;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Basket {

    private double price;
    ArrayList<Product> basket = new ArrayList<Product>();

    public double Pay(double value)
    {
        if(value >= getPrice())
        {
            basket.clear();
            value = value - getPrice();
            System.out.println("Thank you and goodbye");
        }
        else
            System.out.println("You don't have enough money");

        return value;
    }

    public void Insert_Product(Product new_product) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("How many units do you want?");
        var product = new_product;
        int units = myObj.nextInt();
        boolean same_product= false;

            for (int i = 0; i < basket.size(); i++) {
                if (product.getName() == basket.get(i).getName()) {
                    basket.get(i).setUnits(basket.get(i).getUnits() + units);
                    same_product= true;
                }
            }

            if(!same_product) {
                product.setUnits(units);
                basket.add(product);
            }

        setPrice(getPrice()+product.getPrice()*units);
        Basket_Information();
    }

    public void remove_Product()
    {

        System.out.println("Which product do you want to remove? (Give a number)");
        Basket_Information();
        Scanner myObj = new Scanner(System.in);

        int position = myObj.nextInt();
        position--;

        System.out.println("How many units do you want to remove?");
        System.out.println("Put " + basket.get(position).getUnits() + " to remove product completly");
        int units = myObj.nextInt();

        setPrice(getPrice()-basket.get(position).getPrice()*units);

        if(basket.get(position).getUnits()==units) {
            basket.remove(position);
        }
        else{
            basket.get(position).setUnits(basket.get(position).getUnits() - units);
        }
        Basket_Information();
    }

    public void remove_all_Product() { basket.clear(); }

    public void Basket_Information()
    {
        if(basket.size()>0) {
            for (int i = 0; i < basket.size(); i++) {
                System.out.printf(Locale.US,i + 1 + ". %-20s %-20s %.2f\n",
                        basket.get(i).getName(),
                        basket.get(i).getUnits(),
                        basket.get(i).getPrice() * basket.get(i).getUnits());
            }
            System.out.printf(Locale.US,"Together %.2f \n", getPrice());
        }

        else
            System.out.println("Basket is empty");
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

}
