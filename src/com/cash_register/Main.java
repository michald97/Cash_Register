package com.cash_register;

import java.util.Scanner;

public class Main {

    public static void view_options(){
        String format = "%-20s %5s\n";
        System.out.println("Welcome to Cash Register system.");
        System.out.println("What would you like to do ?");
        System.out.format(format, "[1]", "View list");
        System.out.format(format, "[2]", "Add Object to list");
        System.out.format(format, "[3]", "Remove object from list");
        System.out.format(format, "[4]", "Change name of Object");
        System.out.format(format, "[5]", "Change price of Object");
        System.out.format(format, "[6]", "View Basket");
        System.out.format(format, "[7]", "Add object to basket");
        System.out.format(format, "[8]", "Remove object from basket");
        System.out.format(format, "[9]", "Clear basket");
        System.out.format(format, "[10]", "View Credit");
        System.out.format(format, "[11]", "Recharge Credit");
        System.out.format(format, "[12]", "Reduce Credit");
        System.out.format(format, "[13]", "Buy");
        System.out.println("Put number of action");
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        var list = new List_Of_Products();
        var basket = new Basket();
        var pocket = new Pocket();
        view_options();
        while(true){
            int action = myObj.nextInt();
            switch(action){
                case 1:
                    list.show_list();
                    break;
                case 2:
                    list.add_product();
                    break;
                case 3:
                    list.remove_product();
                    break;
                case 4:
                    list.change_name();
                    break;
                case 5:
                    list.change_value();
                    break;
                case 6:
                    basket.Basket_Information();
                    break;
                case 7:
                    var product = list.getProduct();
                    basket.Insert_Product(product);
                    break;
                case 8:
                    basket.remove_Product();
                    break;
                case 9:
                    basket.remove_all_Product();
                    break;
                case 10:
                    pocket.information();
                    break;
                case 11:
                    pocket.recharge_Credit();
                    break;
                case 12:
                    pocket.reduce_Credit();
                    break;
                case 13:
                    double credit = basket.Pay(pocket.getCredit());
                    pocket.setCredit(credit);
                    break;
                default:
            }
            view_options();
        }
    }
}
