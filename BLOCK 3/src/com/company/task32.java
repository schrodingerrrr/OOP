package com.company;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class task32 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строчку: ");
        String str = reader.readLine();
        System.out.print(findZip(str));
    }
    public static String findZip(String str) {
        int v1 = str.indexOf("zip");
        int v2 = str.indexOf("zip", v1 + 3);
        if (v2 == -1){
            return "В данной строке нет второго вхождения 'zip' ";
        }
        else{
            return "Второе вхождение в этой строчке начинается с индекса: " + Integer.toString(v2);
        }
    }
}
