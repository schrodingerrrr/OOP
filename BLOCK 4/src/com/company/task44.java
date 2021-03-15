package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class task44 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] array = new double[4];
        System.out.print("Введите время начала рабочего дня: ");
        String sstart = reader.readLine();
        System.out.print("Введите время окончания рабочего дня: ");
        String sfinish = reader.readLine();
        System.out.print("Введите вашу ставку: ");
        String sstav = reader.readLine();
        System.out.print("Введите множитель ставки за переработку: ");
        String smnoz = reader.readLine();
        array[0] = Double.parseDouble(sstart);
        array[1] = Double.parseDouble(sfinish);
        array[2] = Double.parseDouble(sstav);
        array[3] = Double.parseDouble(smnoz);
        double itog = overtime(array);
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.print("В этот день вы заработаете: $" + f.format(itog));
    }
    public static double overtime(double[] array){
        double sum = 0;
        if (array[1] <= 17)
            return (array[1] - array[0]) * array[2];
        else
            return (17 - array[0]) * array[2] + (array[1] - 17) * array[2] * array[3];
    }
}
