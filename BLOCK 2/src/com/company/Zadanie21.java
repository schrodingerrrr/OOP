package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie21 {

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите строку: ");
            String stroke = reader.readLine();
            System.out.print("Введите количество повторений символов: ");
            String s = reader.readLine();
            int n = Integer.parseInt(s);
            repeat(stroke, n);
        }
        public static void repeat(String stroke, int n){
            for (int i = 0; i < stroke.length(); i++){
                char charConcrete = stroke.charAt(i);
                for (int c = 0; c < n; c++)
                    System.out.print(charConcrete);
            }
        }
    }

