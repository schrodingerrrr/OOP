package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task42 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String s = reader.readLine();
        System.out.print(split(s));
    }
    public static ArrayList split(String s){
        String element = "";
        int countleft = 0, countright = 0, n = -1;
        ArrayList klaster = new ArrayList();
        for (int i = 0; i < s.length(); i++){
            char sim = s.charAt(i);
            if (sim == '(')
                countleft += 1;
            else if (sim == ')')
                countright += 1;
            element += sim;
            if (countleft == countright){
                countleft = 0;
                countright = 0;
                n += 1;
                klaster.add(element);
                element = "";
            }
        }
        return klaster;
    }
}
