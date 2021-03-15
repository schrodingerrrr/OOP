package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t56 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите номер кредитной карты: ");
        String s = reader.readLine();
        validateCard(s);
    }
    public static int multiplication(int x){
        int result = x * 2;
        while (result > 9){
            int newResult = 0;
            while (result > 0){
                newResult += result % 10;
                result /= 10;
            }
            result = newResult;
        }
        return result;
    }
    public static void validateCard(String s){
        int kontrol = Integer.parseInt(s.substring(s.length() - 1));
        System.out.println("Контрольная цифра: " + kontrol);
        long reverse = Long.parseLong(reverse(s));
        System.out.println("Перевернутая строка без последней цифры: " + reverse);
        String stringReverse = Long.toString(reverse);
        String newStringReverse = "";
        int num;
        for (int i = 0; i < Long.toString(reverse).length(); i++){
            if (i % 2 == 0){
                num = multiplication(Integer.parseInt(String.valueOf(stringReverse.charAt(i))));
            }
            else{
                num = Integer.parseInt(String.valueOf(stringReverse.charAt(i)));
            }
            newStringReverse += num;
        }
        System.out.println("Строка с умноженными цифрами, стоящими на нечетных похициях: " + newStringReverse);
        if ((10 - sumReverse(newStringReverse) % 10) == kontrol)
            System.out.print("Кредитная карта валидна");
        else
            System.out.print("Кредитная карта не валидно");
    }
    public static String reverse(String s){
        String result = "";
        for (int i = s.length() - 2; i >= 0; i--)
            result += s.charAt(i);
        return result;
    }
    public static int sumReverse(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }
}
