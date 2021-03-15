package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task46 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        String sn = reader.readLine();
        int n = Integer.parseInt(sn);
        int k = 0;
        System.out.print("Мультипликаторное постоянство числа " + n + " равно " + bugger(n, k));
    }
    public static int bugger(int n, int k){
        int p = 1;
        if (n < 10)
            return k;
        else{
            k += 1;
            while (n > 0) {
                p *= n % 10;
                n /= 10;
            }
            return bugger(p, k);
        }
    }
}
