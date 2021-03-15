package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Zadanie10 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Число а ");
        int per1 = in.nextInt();
        System.out.print("Число b ");
        int per2 = in.nextInt();
        System.out.print("Число с ");
        int per3 = in.nextInt();
        System.out.println(abcmath(per1, per2, per3));
    }
    public static String abcmath (int a, int b, int c){
        for (int i=0; i<b; i++) {
            a += a;
        }
        if(a%c==0){
            return "а после изменения делится на с";
        }
        else{
            return "a после изменения не делится с";
        }

    }
}
