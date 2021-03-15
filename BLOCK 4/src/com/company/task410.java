package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task410 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String s = reader.readLine();
        System.out.print("Введите разделитель: ");
        String sym1 = reader.readLine();
        char sym = sym1.charAt(0);
        System.out.print("Количество уникальных символов: " +  countUniqueBooks(s, sym));
    }
    public static int countUniqueBooks(String s, char sym){
        int countsym = 0;
        ArrayList groups = new ArrayList();
        ArrayList symvols = new ArrayList();
        String mezdy = "";
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x != sym && countsym == 1)
                mezdy += x;
            else if (x == sym)
                countsym += 1;
            if (countsym == 2){
                groups.add(mezdy);
                mezdy = "";
                countsym = 0;
            }
        }
        System.out.println(groups.toString());
        for (int i = 0; i < groups.size(); i++){
            String word = (String) groups.get(i);
            for (int j = 0; j < word.length(); j++ ){
                char x = word.charAt(j);
                if (!(symvols.contains(x))){
                    symvols.add(x);
                }
            }
        }
        return symvols.size();
    }
}
