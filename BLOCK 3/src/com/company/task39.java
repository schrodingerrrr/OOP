package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task39 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        String s = reader.readLine();
        int x = Integer.parseInt(s);
        System.out.print(nextPrime(x));
    }
    public static boolean isPrime(int x){
        boolean Prime = true;
        for (int i = 2; i < x; i++){
            if (x % i == 0)
                Prime = false;
        }
        return Prime;
    }
    public static String nextPrime(int x){
        int a = x;
        while (true){
            if (isPrime(a))
                return "Следующее после " + x + " простое число: " + a;
            else
                a += 1;
        }
    }

}
