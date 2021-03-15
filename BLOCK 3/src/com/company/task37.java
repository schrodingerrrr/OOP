package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task37 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        int n2 = n * n;
        int len = Integer.toString(n2).length();
        System.out.print(isKaprekar(n, n2, len));
    }
    public static String isKaprekar(int n, int k, int len){
        String left = "", right = "", v = "";
        if (len == 1){
            right = Integer.toString(k);
            if (Integer.parseInt(right) == n)
                v = "Число " + n + " является числом Капрекара";
            else
                v = "Число " + n + " не является числом Капрекара";;
        }
        else if (len % 2 == 0){
            left = Integer.toString(k).substring(0, len / 2);
            right = Integer.toString(k).substring(len / 2);
            if (Integer.parseInt(left) + Integer.parseInt(right) == n)
                v = "Число " + n + " является числом Капрекара";
            else
                v = "Число " + n + " не является числом Капрекара";
        }
        else{
            for (int i = 0; i < len / 2; i++){
                left += Integer.toString(k).charAt(i);
                if ((Integer.parseInt(left) + Integer.parseInt(Integer.toString(k).substring(i + 1))) == n)
                    v = "Число " + n + " является числом Капрекара";
                else
                    v = "Число " + n + " не является числом Капрекара";
            }
        }
        return v;
    }
}
