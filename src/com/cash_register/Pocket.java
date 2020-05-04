package com.cash_register;

import java.util.Locale;
import java.util.Scanner;

public class Pocket {

    private double credit;

    public void information()
    {
        if(credit==0)
            System.out.println("Your pocket is empty");
        else
            System.out.printf("Your credit is %.2f \n", getCredit());
    }

    public void recharge_Credit() {
        Scanner myObj = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("How much do you want to recharge");
        double value = myObj.nextDouble();
        this.credit = this.credit + value;
        information();
    }

    public void reduce_Credit() {
        Scanner myObj = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("How much do you want to reduce");
        double value = myObj.nextDouble();
        this.credit = this.credit - value;
        information();
    }

    public void setCredit(double credit) { this.credit = credit; }
    public double getCredit() { return credit; }
}
