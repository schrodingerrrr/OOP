package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class t51 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку для шифрования: ");
        String s = reader.readLine();
        System.out.print("Введите массив для дешифрования через пробел: ");
        String arr = reader.readLine();
        String[] array = arr.split(" ");
        encrypt(s);
        decrypt(array);
    }
    public static void encrypt(String s){
        List<Integer> result = new ArrayList<Integer>();
        result.add((int)s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            result.add((int)s.charAt(i) - (int)s.charAt(i - 1));
        }
        System.out.println("Ваша строка выглядит следующим образом: " + result);
    }
    public static void decrypt(String[] array){
        String result = "";
        char sym = (char)Integer.parseInt(array[0]);
        result += sym;
        for (int i = 1; i < array.length; i++){
            sym = (char) ((int) sym + Integer.parseInt(array[i]));
            result += sym;
        }
        System.out.println( "Ваша строка выглядит следующим образом: " + result);
    }

}
