package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie29 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите слово: ");
        String word = reader.readLine();
        System.out.print("Введите суффикс: ");
        String suffix = reader.readLine();
        System.out.print("Введите префикс: ");
        String prefix = reader.readLine();
        System.out.println(isPrefix(word, prefix));
        System.out.println(isSuffix(word, suffix));
    }
    public static String isPrefix(String word, String prefix){
        if (word.substring(0, prefix.length() - 1).equals(prefix.substring(0, prefix.length() - 1)))
            return "Строка начинается с префиксного аргумента";
        else {
            System.out.println(word.substring(0, prefix.length() - 1));
            System.out.println(prefix.substring(0, prefix.length() - 1));
            return "Строка не начинается с префиксного аргумента";
        }
    }
    public static String isSuffix(String word, String suffix){
        if (word.substring(word.length() - suffix.length() + 1).equals(suffix.substring(1)))
            return "Строка заканчивается аргументом суффикса";
        else
            return "Строка не заканчивается аргументом суффикса";
    }
}
