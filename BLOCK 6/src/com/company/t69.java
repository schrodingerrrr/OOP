package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t69 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите формулу: ");
        String s = reader.readLine();
        formule(s);
    }

    public static void formule(String s) {
        String[] parts = s.replaceAll("\\s", "").split("=");
        if (check(Generation(parts)))
            System.out.print("Формула верна");
        else
            System.out.print("В формуле допущена ошибка");
    }

    public static List<Double> Generation(String[] parts) {
        List<Double> numbers = new ArrayList<Double>();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains("+")) {
                numbers.add(Double.parseDouble(parts[i].substring(0, parts[i].indexOf("+"))) + Double.parseDouble(parts[i].substring(parts[i].indexOf("+") + 1)));
            } else if (parts[i].contains("*")) {
                numbers.add(Double.parseDouble(parts[i].substring(0, parts[i].indexOf("*"))) * Double.parseDouble(parts[i].substring(parts[i].indexOf("*") + 1)));
            } else if (parts[i].contains("-")) {
                numbers.add(Double.parseDouble(parts[i].substring(0, parts[i].indexOf("-"))) - Double.parseDouble(parts[i].substring(parts[i].indexOf("-") + 1)));
            } else if (parts[i].contains("/")) {
                numbers.add(Double.parseDouble(parts[i].substring(0, parts[i].indexOf("/"))) / Double.parseDouble(parts[i].substring(parts[i].indexOf("/") + 1)));
            } else{
                numbers.add(Double.parseDouble(parts[i]));
            }
        }
        return numbers;
    }
    public static boolean check (List<Double> numbers){
        for (int i = 0; i < numbers.size(); i++){
            for (int j = i + 1; j < numbers.size(); j++){
                if (!numbers.get(i).equals(numbers.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
