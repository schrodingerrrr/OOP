package com.company;
import java.io.IOException;
import java.util.Scanner;
public class Zadanie9 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число элементов массива ");
        int per1 = in.nextInt();
        int nums[] = new int[per1];
        for (int i = 0; i < per1; i++) {
            System.out.print("Введите " + i + " элемент массива ");
            nums[i] = in.nextInt();
        }
        System.out.println("Сумма кубов элементов массива: " + sumOfCubes(nums));

    }
    public static int sumOfCubes(int[] Array){
        int s = 0;
        int len = Array.length;
        for (int i=0; i<len; i++){
            s+= Math.pow(Array[i], 3);
        }
        return s;
    }
}
