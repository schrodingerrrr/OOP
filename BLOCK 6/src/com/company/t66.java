package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class t66 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите номер числа в последовательности Улана: ");
        int x = Integer.parseInt(reader.readLine());
        ulan(x);
    }
    public static void ulan(int x){
        List<Integer> Ulans_numbers = new ArrayList<Integer>();
        Ulans_numbers.add(1);
        Ulans_numbers.add(2);
        int len = 2;
        int nextNum = 3;
        int count = 0;
        while (len < x){
            for (int i = 0; i < len; i++){
                for (int j = i + 1; j < len; j++){
                    if ((Ulans_numbers.get(i) + Ulans_numbers.get(j)) == nextNum){
                        count += 1;
                    }
                }
            }
            if (count == 1){
                Ulans_numbers.add(nextNum);
                len += 1;
            }
            count = 0;
            nextNum += 1;
        }
        if (x == 1 || x == 2)
            System.out.println(x + " число в последовательнсоти Улана равно " + x);
        else
            System.out.println(x + " число в последовательнсоти Улана равно " + Ulans_numbers.get(len - 1));
    }
}

