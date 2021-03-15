package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class t63 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите rgb или rgba значения: ");
        String s = reader.readLine();
        if(validColor(s))
            System.out.println("Данные введены корректно");
        else
            System.out.println("Данные введены некорректно");
    }
    public static boolean validColor(String s){
        int left = s.indexOf('(');
        int right = s.indexOf(')');
        String between = s.substring(left + 1, right);
        String[] betweenArr = between.split(",");
        boolean check = true;
        for (int i = 0; i < betweenArr.length; i++){
            betweenArr[i].replaceAll("\\s", "");
            if (betweenArr[i].equals(""))
                check = false;
        }
        if (!check)
            return false;
        if (s.substring(0, left).equals("rgb") && betweenArr.length != 3) {
            check = false;
        }
        else if (s.substring(0, left).equals("rgba") && betweenArr.length != 4){
            check = false;
        }
        else if (!(s.substring(0, left).equals("rgb") || s.substring(0, left).equals("rgba"))){
            check = false;
        }
        if (!check)
            return false;
        for (int i = 0; i < betweenArr.length; i++){
            if (Double.parseDouble(betweenArr[i]) < 0 || Double.parseDouble(betweenArr[i]) > 255)
                check = false;
        }
        return check;
    }
}
