package com.company;
import java.util.Scanner;
public class Zadanie5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите чсло N ");
        int per1 = in.nextInt();
        System.out.print("Введите чсло a ");
        int per2 = in.nextInt();
        System.out.print("Введите чсло b ");
        int per3 = in.nextInt();
        System.out.println(operation(per1, per2, per3));
        }
        public static String operation (int N, int a, int b) {
            if (a + b == N) {
                return "Нужно выполнить сложение";
            }
            if (a - b == N) {
                return "Нужно выполнить вычитание ";
            }
            if (a * b == N) {
                return "Нужно выполнить умножение ";
            }
            if (a / b == N) {
                return "Нужно выполнить деление";
            }
        else {
                return "Исходное число невозможно получить из чисел a и b";
            }
    }
}
