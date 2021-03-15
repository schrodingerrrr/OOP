package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class t510 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        int n = Integer.parseInt(reader.readLine());
        hexLattice(n);
    }
    public static void hexLattice(int n){
        boolean check = false;
        int kol = 0;
        for (int i = 1; recurs(i) <= n; i++){
            if (recurs(i) == n) {
                check = true;
                kol = i;
            }
        }
        if (check == false)
            System.out.println("Число " + n + " не является центрированным шестиугольным числом");
        else{

            int copy = kol;
            int kolProb = kol - 1;
            for (int i = 0; i < kol; i++){
                for (int k = 0; k < kolProb; k++)
                    System.out.print(" ");
                for (int j = 0; j < copy; j++){
                    System.out.print("o ");
                }
                copy += 1;
                System.out.println();
                kolProb--;
            }
            kolProb = 1;
            for (int i = 0; i < kol - 1; i++){
                for (int k = 0; k < kolProb; k++)
                    System.out.print(" ");
                copy -= 1;
                for (int j = 0; j < copy - 1; j++){
                    System.out.print("o ");
                }
                System.out.println();
                kolProb++;
            }
        }
    }
    public static int recurs(int n){
        if (n == 1)
            return 1;
        else
            return (n * 6 - 6 + recurs(n - 1));
    }
}
