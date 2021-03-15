package com.company;

import java.util.Scanner;

public class Zadanie3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Количество куриц ");
        int per1 = in.nextInt();
        System.out.print("Количество коров ");
        int per2 = in.nextInt();
        System.out.print("Количество свиней ");
        int per3 = in.nextInt();
        System.out.print("Всего ног "+animals(per1,per2,per3)+" ног");
    }
    public static int animals(int a, int b, int c) { return 2 * a + 4 * (b + c); }
}
