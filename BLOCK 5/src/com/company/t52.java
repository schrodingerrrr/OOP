package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t52 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Предположим, что вы играете за сторону белых");
        System.out.print("Введите название фигуры: ");
        String x = reader.readLine();
        System.out.print("Введите стартовое положение фигуры: ");
        String y = reader.readLine();
        System.out.print("Введите конечное положение фигуры: ");
        String z = reader.readLine();
        int s1 = numbers(y.charAt(0)), s2 = (int) y.charAt(1), f1 = numbers(z.charAt(0)), f2 = (int) z.charAt(1);
        System.out.println(canMove(x, s1, s2, f1, f2, y, z));
    }
    public static int numbers(char x) {
        int m = 0;
        switch (x) {
            case 'A': m = 1; break;
            case 'B': m = 2; break;
            case 'C': m = 3; break;
            case 'D': m = 4; break;
            case 'E': m = 5; break;
            case 'F': m = 6; break;
            case 'G': m = 7; break;
            case 'H': m = 8; break;
        }
        return m;
    }
    public static String canMove(String name, int s1, int s2, int f1, int f2, String y, String z) {
        boolean flag = false;
        switch (name) {
            case "Пешка": if (s1 == f1 && (s2 + 1 == f2)) flag = true; break;
            case "Конь": if ((Math.abs((s2 - f2)) == 2 && Math.abs(s1 - f1) == 1) || (Math.abs((s1 - f1)) == 2 && Math.abs(s2 - f2) == 1)) flag = true; break;
            case "Слон": if (Math.abs(s1 - f1) == Math.abs(s2 - f2)) flag = true; break;
            case "Ладья": if (s1 == f1 || s2 == f2) flag = true; break;
            case "Ферзь": if ((Math.abs(s1 - f1) == Math.abs(s2 - f2)) || (s1 == f1 || s2 == f2)) flag = true; break;
            case "Король": if (((Math.abs(s1 - f1) == Math.abs(s2 - f2)) || (s1 == f1 || s2 == f2)) && (s1 - f1 == 1 || s2 - f2 == 1)) flag = true; break;
        }
        if (flag)
            return name + " может сделать ход из клетки " + y + " в клетку " + z;
        else
            return name + " не может сделать ход из клетки " + y + " в клетку " + z;
    }

    
}
