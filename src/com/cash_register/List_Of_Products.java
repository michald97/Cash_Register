package com.cash_register;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class List_Of_Products {

    ArrayList<Product> List = new ArrayList<Product>();


    public List_Of_Products() {
        var onions = new Product("Onions",5.99);
        var potatoes = new Product("Potatoes", 6.99);
        var water = new Product("Water 1 liter", 1.99);
        var candy_bar = new Product("Candy Bar", 2.49);
        List.add(onions);
        List.add(potatoes);
        List.add(water);
        List.add(candy_bar);
    }

    public void show_list()
    {
        System.out.println("List of available products.");
        for (int i = 0; i < List.size(); i++) {
            System.out.printf(Locale.US,i+1 + ". %-20s %.2f\n", List.get(i).getName(), List.get(i).getPrice());
        }
    }

    public void add_product(){

        Scanner myObj = new Scanner(System.in).useLocale(Locale.US);;
        System.out.println("Give name of product");
        String product_name = myObj.nextLine();

        for (int i = 0; i < List.size(); i++) {
            if (product_name.equals(List.get(i).getName())) {
                System.out.println("Product is already on the list");
                break;
            }
            else
            {
                System.out.println("Give price of product");
                double price = myObj.nextDouble();

                var new_product = new Product(product_name, price);
                List.add(new_product);

                System.out.println("Product was added to list");
                show_list();
            }
        }
    }


    public void remove_product() {
        show_list();
        System.out.println("Which product do you want to substract? (Give a number)");

        int position = getPosition();
        List.remove(position);
        System.out.println("Product was substract from list");

        show_list();
    }

    public void change_name()
    {
        show_list();
        System.out.println("Which product's name do you want to change? (Give a number)");
        Scanner myObj = new Scanner(System.in);
        int position = getPosition();
        System.out.println("Set name");
        String new_name=myObj.nextLine();
        List.get(position).setName(new_name);
        show_list();
    }

    public void change_value()
    {
        show_list();
        System.out.println("Which product's price do you want to change? (Give a number)");
        Scanner myObj = new Scanner(System.in).useLocale(Locale.US);
        int position = getPosition();
        System.out.println("Set price");
        double new_price = myObj.nextDouble();
        List.get(position).setPrice(new_price);
        show_list();
    }


    public Product getProduct()
    {
        show_list();
        System.out.println("Which product do you want to purchase? (Give a number)");
        int position = getPosition();
        return List.get(position);
    }

    public int getPosition()
    {
        Scanner myObj = new Scanner(System.in).useLocale(Locale.US);
        int position = myObj.nextInt();
        position--;
        return position;
    }

}
