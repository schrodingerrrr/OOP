package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class task48 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] values = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y'};
        System.out.print("Введите первую строчку: ");
        String s1 = reader.readLine();
        System.out.print("Введите вторую строчку: ");
        String s2 = reader.readLine();
        String [] splits1 = s1.split(" ");
        String [] splits2 = s2.split(" ");
        String slovo1 = splits1[splits1.length - 1];
        String slovo2 = splits2[splits2.length - 1];
        System.out.print(doesRhyme(slovo1, slovo2, values));
    }
    public static String doesRhyme(String slovo1, String slovo2, char[] liters){
        String news1 = "", news2 = "";
        for (int i = 0; i < slovo1.length(); i++){
            char sym = slovo1.charAt(i);
            if (Arrays.asList(liters).contains(sym))
                news1 += sym;
        }
        for (int i = 0; i < slovo1.length(); i++){
            char sym = slovo2.charAt(i);
            if (Arrays.asList(liters).contains(sym))
                news2 += sym;
        }
        news1 = news1.toLowerCase();
        news2 = news2.toLowerCase();
        if (news1 == news2)
            return "Эти строки рифмуются";
        else
            return "Эти строки не рифмуются";
    }
}
