package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t610 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        String s = reader.readLine();
        System.out.println(palindromedescedent(s));
    }
    public static boolean isPalindrome(String s){
        String backward = "";
        for (int i = s.length() - 1; i >= 0; i--){
            backward += s.charAt(i);
        }
        if (s.equals(backward))
            return true;
        else
            return false;
    }
    public static String palindromedescedent(String s){
        if (isPalindrome(s)){
            return "Число " + s + " является палиндромом";
        }
        else{
            System.out.print("Потомки этого числа: ");
            String newS = s;
            while (!isPalindrome(newS)){
                int k = newS.length() / 2;
                if (k == 0)
                    return "Число " + newS + " является палиндромом";
                int[] potomok = new int[k];
                int j = 0;
                for (int i = 0; i < k; i++){
                    potomok[i] = Integer.parseInt(String.valueOf(newS.charAt(j))) + Integer.parseInt(String.valueOf(newS.charAt(j + 1)));
                    j += 2;
                }
                newS = "";
                for (int i = 0; i < potomok.length; i++){
                    newS += Integer.toString(potomok[i]);
                }
                System.out.print(newS + " ");
            }
            System.out.println();
            return "Число " + newS + " является потомком числа " + s + " и является палиндромом";
        }
    }
}
