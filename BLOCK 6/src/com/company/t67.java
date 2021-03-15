package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t67 {
    public static void main(String[] args) throws IOException  {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите cтроку: ");
        String str = read.readLine();
        System.out.print("Самая длинная неповторяющаяся подстрока: " + longestNonrepeatingSubstring(str));
    }
    public static String longestNonrepeatingSubstring(String str){
        String longestStr = "";
        String tempStr = "";
        for(int i = 0; i < str.length(); i++){
            if (tempStr.indexOf(str.charAt(i)) == -1){
                tempStr += str.charAt(i);
            }
            else{
                if (longestStr.length() < tempStr.length()){
                    longestStr = tempStr;
                    tempStr = "";
                }
            }
        }
        if (tempStr.length() > longestStr.length()){
            longestStr = tempStr;
        }
        return longestStr;
    }
}
