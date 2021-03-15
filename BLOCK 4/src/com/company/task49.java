package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task49 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите первое число: ");
        String num1 = reader.readLine();
        System.out.print("Введите второе число: ");
        String num2 = reader.readLine();
        System.out.print(trouble(num1, num2));
    }
    public static String trouble(String num1, String num2){
        boolean result = false;
        int count = 1;
        for (int i = 1; i < num1.length(); i++){
            if (num1.charAt(i) == num1.charAt(i - 1)){
                count += 1;
                if (count == 3){
                    int count2 = 0;
                    char number = num1.charAt(i);
                    for (int j = 0; j < num2.length(); j++){
                        if (num2.charAt(j) == number){
                            count2 += 1;
                            if (count2 == 2) {
                                result = true;
                                System.out.println(num2.charAt(j));
                            }
                        } else
                            count2 = 0;
                    }
                }
            }
            else {
                count = 1;
            }
        }
        if (result)
            return "Такое число существует";
        else
            return "Такое число не существует";
    }
}
