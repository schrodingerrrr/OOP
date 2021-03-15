package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Zadanie24 {
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
        System.out.println(Arrays.toString(cumulativeSum(Array, n)));
    }
    public static int[] cumulativeSum(int[] Array, int n){
        double s = 0;
        int sum = 0;
        int[] NewArray = new int[n];
        for (int i = 0; i < Array.length; i++){
            for (int j = 0; j < i; j++)
                s += Array[j];
            NewArray[i] += s + Array[i];
            s = 0;
        }
        return NewArray;
    }
}

