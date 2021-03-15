package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task34 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String s = reader.readLine();
        System.out.print(flipEndChars(s));
    }

    public static String flipEndChars(String s) {
        if (s.length() < 2)
            return "Несовместимо";
        else if (s.charAt(0) == s.charAt(s.length() - 1))
            return "Два - это пара";
        else
            return s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
    }
}
