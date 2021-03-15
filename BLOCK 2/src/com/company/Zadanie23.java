package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie23 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите количество элементов массива: ");
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        int [] Array = new int[n];
        for (int i = 0; i < n; i++){
            System.out.print("Введите " + i + " элемент массива: ");
            String s1 = reader.readLine();
            Array[i] = Integer.parseInt(s1);
        }
        System.out.println(isAvgWhole(Array, n));
    }
    public static String isAvgWhole(int[] Array, int n){
        double s = 0;
        for (int i = 0; i < Array.length; i++)
            s += Array[i];
        if (s / n % 1 == 0)
            return "Среднее значение всех элементов является целым числом";
        else
            return "Среднее значение всех элементов не является целым числом";
    }
}
