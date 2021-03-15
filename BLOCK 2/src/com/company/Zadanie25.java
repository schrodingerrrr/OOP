package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie25 {

        public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите вещественное число: ");
        String x = reader.readLine();
        System.out.println("Число имеет " + getDecimalPlaces(x) + " знака после запятой");
    }
    public static int getDecimalPlaces(String x){
        String thk = ".";
        if (x.contains(thk))
            return x.length() - x.indexOf(thk) - 1;
        else
            return 0;
    }
}
