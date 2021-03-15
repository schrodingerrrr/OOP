package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t62 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите предложение для перевода на поросячью латынь: ");
        String s = reader.readLine();
        translateSentence(s);
    }
    public static String translateWord(String s){
        String result = "";
        if (isGlas(s.charAt(0))){
            result = s + "yay";
        }
        else{
            int ind = 0;
            for (int i = 0; i > -1; i++){
                if (!isGlas(s.charAt(i))){
                    ind += 1;
                }
                else
                    break;
            }
            result = s.substring(ind) + s.substring(0, ind) + "ау";
        }
        return result;
    }
    public static void translateSentence(String s){
        String result = "";
        s = s.substring(0, s.length() - 1);
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i ++){
            result += translateWord(words[i]) + " ";
        }
        result = result.substring(0, result.length() - 1) + ".";
        System.out.println("Предложение: " + s);
        System.out.print("На свинском латинском будет звучать так: " + result);
    }
    public static boolean isGlas(char x){
        char[] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x)
                return true;
        }
        return false;
    }

}
