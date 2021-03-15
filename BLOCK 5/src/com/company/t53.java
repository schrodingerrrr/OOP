package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t53 {
    public static void main(String[] args) throws IOException  {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите часть слова: ");
        String str1 = read.readLine();
        System.out.print("Введите полное слово: ");
        String str2 = read.readLine();
        System.out.print(canComplete(str1, str2));
    }
    public static String canComplete(String str1, String str2){
        int i = 0;
        int j = 0;
        while ((i < str1.length()) && ( j < str2.length())){
            if (str1.charAt(i) == str2.charAt(j)){
                i += 1;
            }
            j += 1;
        }
        if (i == str1.length()){
            return "Слово может быть завершено";
        }
        else{
            return "Слово не может быть завершено";
        }
    }
}
