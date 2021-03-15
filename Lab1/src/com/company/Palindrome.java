package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Класс создан для поиска и вывода всех слов в строке, которые являются палиндромами
public class Palindrome {
    public static void main(String[] args)throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите все слова через пробел: ");
        String str = read.readLine();
        String[] strArr = str.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            if (isPalindrome(s)){
                System.out.println(s + " является палиндромом");
            }
        }
    }
    // Метод возвращает слово, написанное наоборот
    public static String reverseString(String s) {
        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--){
            reverse += s.charAt(i);
        }
        return reverse;
    }
    // Метод проверяет, является ли слово палиндромом
    public static boolean isPalindrome(String s){
        return (s.equals(reverseString(s)));
    }
}
