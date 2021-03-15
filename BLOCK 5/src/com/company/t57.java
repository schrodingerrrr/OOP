package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class t57 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число для перевода на анлийский язык: ");
        int num = Integer.parseInt(reader.readLine());
        System.out.print("Введите число для перевода на русский язык: ");
        int num2 = Integer.parseInt(reader.readLine());
        numToEng(num);
        numToRus(num2);
    }
    public static void numToEng(int num){
        String[] zero_twenty = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] dozens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String result = "";
        if (num <= 19) // Проверка на число, меньшее 20
            result += zero_twenty[num];
        else if (num <= 99){ //Проверка на число, меньшее 100
            if (num % 10 == 0)
                result += dozens[num / 10];
            else
                result += dozens[num / 10] + "-" + zero_twenty[num % 10];
        }
        else{
            if (num % 100 == 0) // Проверка на число вида X00
                result += zero_twenty[num / 100] + " hundred";
            else if (num / 10 % 10 == 0) // Проверка на число вида x0y
                result += zero_twenty[num / 100] + " hundred" + zero_twenty[num % 10];
            else if (num % 10 == 0) //Проверка на число вида xy0
                result += zero_twenty[num / 100] + " hundred " + dozens[num / 10 % 10];
            else
                result += zero_twenty[num / 100] + " hundred " + dozens[num / 10 % 10] + "-" + zero_twenty[num % 10];

        }
        System.out.println("Число " + num + " на английском языке будет написано так: " + result);
    }
    public static void numToRus(int num){
        String[] zero_twenty = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнацдцать", "шестнадца", "семнадцать", "восемнадцать", "девятнадцать"};
        String[] dozens = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String [] hundreds = {"", "сто" , "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        String result = "";
        if (num <= 19)
            result += zero_twenty[num];
        else if (num <= 99){
            if (num % 10 == 0)
                result += dozens[num / 10];
            else
                result += dozens[num / 10] + " " + zero_twenty[num % 10];
        }
        else{
            if (num % 100 == 0)
                result += hundreds[num / 100];
            else if (num / 10 % 10 == 0)
                result += hundreds[num / 100] + " " + zero_twenty[num % 10];
            else if (num % 10 == 0)
                result += hundreds[num / 100] + " " + dozens[num / 10 % 10];
            else
                result += hundreds[num / 100] + " " + dozens[num / 10 % 10] + " " + zero_twenty[num % 10];
        }
        System.out.print("Число " + num + " на русском языке будет написано так: " + result);
    }
}
