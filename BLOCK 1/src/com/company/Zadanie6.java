package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Zadanie6 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите символ ");
        String ch = in.nextLine();
        System.out.println("Код символа в ASCII: " + ctoa(ch));
    }
    public static int ctoa(String ch){
        char character = ch.charAt(0);
        int ascii=(int)character;
        return ascii;

    }
}
