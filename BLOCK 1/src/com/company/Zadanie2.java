package com.company;

import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Основание треугольника ");
        double per1 = in.nextDouble();
        System.out.print("Высота треугольника ");
        double per2 = in.nextDouble();
        System.out.print("Площадь треугольника равна "+ triArea(per1,per2));
    }
    public static double triArea(double a, double b) { return a * b / 2; }
}
