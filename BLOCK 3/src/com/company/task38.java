package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task38 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String s = reader.readLine();
        System.out.print(longestZero(s));
    }
    public static String longestZero(String s){
        int max = 0;
        int count = 0;
        for (Character x: s.toCharArray()){
            if (x == '0'){
                count += 1;
                if (count > max)
                    max = count;
            }
            else
                count = 0;
        }
        return "Самая длинная последовательность нулей в строке состоит из " + max + " нулей";
    }
}
