package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task41 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите количество слов: ");
        String sn = reader.readLine();
        System.out.print("Введите количество символов в строке: ");
        String sk = reader.readLine();
        System.out.print("Введите эссе: ");
        String s = reader.readLine();
        int N = Integer.parseInt(sn);
        int K = Integer.parseInt(sk);
        System.out.print(Bessie(s, K));
    }
    public static String Bessie(String s, int K){
        String result = "";
        String new_str = "";
        String[] array;
        array = s.split(" ");
        for(int j = 0; j < array.length; j++){
            if (length_without_space(new_str) + array[j].length() <= K){
                new_str += array[j] + " ";
            }
            else{
                result += new_str + "\n";
                new_str = array[j] + " ";
            }
        }
        result += new_str + "\n";
        return result;
    }
    public static int length_without_space(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                count += 1;
            }
        }
        return s.length() - count;
    }

}
