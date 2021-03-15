package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie28 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите первую строку: ");
        String s1 = reader.readLine();
        System.out.print("Введите вторую строку: ");
        String s2 = reader.readLine();
        System.out.println(isStrangePair(s1, s2));
    }
    public static String isStrangePair(String s1, String s2){
        char s10 = s1.charAt(0);
        char s1x = s1.charAt(s1.length() - 1);
        char s20 = s2.charAt(0);
        char s2x = s2.charAt(s2.length() - 1);
        if (s10 == s2x && s1x == s20)
            return  "Пара строк является странной";
        else
            return "Пара строк не является странной";
    }
}
