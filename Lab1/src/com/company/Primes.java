package com.company;

    // Класс создан для вывода всех простых чисел в диапазоне (2;100]
public class Primes {
        public static void main(String[] args) {
            for(int i = 3; i < 101; i++){
                if (isPrime(i)){
                    System.out.print(i + " ");
                }
            }
        }
        // Метод создан, чтобы узнать является ли вводимое число простым
        public static boolean isPrime(int a){
            // Переменная k считает количество делителей
            int k = 0;
            for (int i = 2; i < a; i++){
                if (a % i == 0){
                    k++;
                }
            }
            return k == 0;
        }
    }


