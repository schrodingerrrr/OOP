package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task45 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите ваш вес: ");
        String Sweight = reader.readLine();
        System.out.print("Введите ваш рост: ");
        String Sheight = reader.readLine();
        double weight = Double.parseDouble(Sweight);
        double height = Double.parseDouble(Sheight);
        System.out.print(BMI(weight, height));
    }
    public static String BMI(double weight, double height){
        double IMT = Math.round(weight * 10 / (height * height)) / 10;
        if (IMT < 18.5)
            return "Ваш ИМТ: " + IMT + " и это ниже нормы";
        else if (IMT >= 25)
            return "Ваш ИМТ: " + IMT + " и это выше нормы";
        else
            return "Ваш ИМТ: " + IMT + " и это норма";
    }
}
