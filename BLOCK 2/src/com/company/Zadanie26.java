package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System.*;
import java.util.Arrays;

public class Zadanie26 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите номер числа в ряду Фибоначчи ");
        String x = reader.readLine();
        int n = Integer.parseInt(x);
        System.out.print(" элемент последовательности Фибоначчи равняется " + Fibonacci(n));
    }
    public static int Fibonacci(int n){
        if (n == 0 || n == 1)
            return 1;
        else
            return (Fibonacci(n - 1) + Fibonacci(n - 2));
    }
}
