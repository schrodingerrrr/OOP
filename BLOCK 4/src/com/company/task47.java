package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class task47 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String s = reader.readLine();
        System.out.print(toStarShorthand(s));
    }
    public static String toStarShorthand(String s){
        int count = 1;
        String result = "";
        int i = 1;
        while (i < s.length()){
            if (s.charAt(i) == s.charAt(i - 1)){
                count += 1;
                if (i == s.length() - 1){
                    result += s.charAt(i) + "*" + count;
                    break;
                }
                else
                    i++;
            }
            else{
                if (count == 1){
                    result += s.charAt(i - 1);
                    if (i == s.length() - 1){
                        result += s.charAt(i);
                    }
                }
                else{
                    result += s.charAt(i - 1) + "*" + count;
                }
                count = 1;
                i++;
            }
        }
        return result;
    }
}
