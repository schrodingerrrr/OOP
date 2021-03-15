package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите конечное число ");
        int per1 = in.nextInt();
        System.out.println("Сумма чисел от 1 до "+ per1 + " равна " + addUpTo(per1));
    }
   public static int addUpTo(int g1) {
       return g1 * (g1 + 1) / 2;

    }
}
