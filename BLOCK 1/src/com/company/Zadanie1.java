package com.company;

import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Введите первое число ");
        int per1 = in.nextInt();
        System.out.print("Введите второе число ");
        int per2 = in.nextInt();
        System.out.print ("Остаток от деления первого числа на второе равен " + remainder(per1, per2));

    }
    public static int remainder(int a, int b) {return a % b;}
}
