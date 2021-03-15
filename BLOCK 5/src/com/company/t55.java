package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class t55 {
    char[] vseglas = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите все слова через пробел: ");
        String[] array = reader.readLine().split(" ");
        sameVovelGroup(array);
    }
    public static boolean isGlas(char x){
        char[] vseglas = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vseglas.length; i++){
            if (vseglas[i] == x)
                return true;
        }
        return false;
    }
    public static void sameVovelGroup(String[] array){
        HashSet glas = new HashSet();
        HashSet newglas = new HashSet();
        HashSet words = new HashSet();
        words.add(array[0]);
        for (int i = 0; i < array[0].length(); i++){
            if (isGlas((array[0].charAt(i))))
                glas.add(array[0].charAt(i));
        }
        System.out.println(glas);
        for (int i = 1; i < array.length; i++){
            newglas.clear();
            for (int j = 0; j < array[i].length(); j++){
                if (isGlas(array[i].charAt(j))){
                    newglas.add(array[i].charAt(j));
                }
            }
            if (glas.equals(newglas)) {
                words.add(array[i]);
            }
        }
        System.out.print("Конечные слова: " + words);

    }
}
