package com.company;

import java.util.Scanner;

public class Zadanie4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Вероятность победы ");
        double per1 = in.nextDouble();
        System.out.print("Выигрыш в случае победы ");
        double per2 = in.nextDouble();
        System.out.print("Стоимость попытки ");
        double per3 = in.nextDouble();
        if (profitableGamble(per1, per2, per3)) {
            System.out.println("Большая вероятность выигрыша");
        } else {
            System.out.println("Маленькая вероятность выигрыша");
        }
    }

    public static boolean profitableGamble(double prob, double prize, double pay) {
        return (prob * prize > pay);
    }
}
