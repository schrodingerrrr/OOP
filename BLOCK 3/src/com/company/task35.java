package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class task35 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String s = reader.readLine();
        System.out.print(isValidHexCode(s.toUpperCase()));
    }

    public static String isValidHexCode(String s) {
        Character[]numbers = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        List<Character> list = Arrays.asList(numbers);
        int count = 0;
        if (s.length() == 7) {
            for (int i = 1; i < 7; i++) {
                if (list.contains(s.charAt(i)))
                    count += 1;
            }
        }
        if ((s.length() == 7) && (Character.toString(s.charAt(0)).equals("#")) && (count == 6))
            return "Число является действительным шестнадцатеричным кодом";
        else
            return "Число не является действительным шестнадцатеричным кодом";
    }
}
