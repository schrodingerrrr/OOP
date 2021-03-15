package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Zadanie27 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (isValid(s) && s.length() == 5 && Integer.parseInt(s) > 0)
            System.out.println("Строка является действительным почтовым индексом");
        else
            System.out.println("Строка не является действительным почтовым индексом");
    }
    public static boolean isValid(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
