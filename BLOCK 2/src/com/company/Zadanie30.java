package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie30 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите стороны треугольника через пробел: ");
        String s = reader.readLine();
        String[] sides = s.split(" ");
        int x = Integer.parseInt(sides[0]);
        int y = Integer.parseInt(sides[1]);
        int z = Integer.parseInt(sides[2]);
        System.out.print(rightTriangle(x, y, z));
    }
    public static String rightTriangle(int x, int y, int z){
        int max = max(max(x, y), z);
        boolean right = false;
        if (x == max) {
            if (x * x == z * z + y * y)
                right = true;
        }
        else if (y == max){
            if (y * y == x * x + z * z)
                right = true;
        }
        else
        if (z * z == x * x + y * y)
            right = true;
        if (right)
            return "Треугольник является прямоугольным";
        else
            return "Треугольник не является прямоугольным";
    }
    public static int max(int x, int y){
        if (x > y)
            return x;
        else
            return y;
    }
}

