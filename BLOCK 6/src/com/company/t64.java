package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class t64 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите URL: ");
        String s = reader.readLine();
        System.out.print("Передайте параметры для удаления через пробел (если их нет, оставьте поле для ввода пустым): ");
        String array = reader.readLine();
        String[] letters = array.split(" "); // Параметры для удаления
        stripUrlParams(s, letters);
    }
    //Получение списка параметров
    public static String getParams(String s){
        return s.substring(s.indexOf('?') + 1);
    }
    //Удаление лишних параметров
    public static String deleting(String s, String[] letters){
        String[] params = getParams(s).split("&");//Получение массива выражений
        String[] chars = new String[params.length * 3];//Получение массива всех символов
        int count = 0; // Для заполнения чара
        // Заполнение чара
        for (int i = 0; i < params.length; i++){
            for (int j = 0; j < params[i].length(); j++){
                chars[count] = String.valueOf(params[i].charAt(j));
                count += 1;
            }
        }
        HashSet<String> bykva = new HashSet<>(); // Множество переменных
        //Заполнение множества переменных
        for (int i = 0; i < chars.length; i += 3){
            bykva.add(chars[i]);
        }
        //Проверка на нулевую длину массива удаляющихся аргументов
        if (letters.length != 0){
            for (int i = 0; i < letters.length; i++){
                bykva.remove(letters[i]);
            }
        }
        String[] bykvas = {};
        bykvas = bykva.toArray(new String[bykva.size()]);
        List<String> new_chars = new ArrayList<String>();
        //Генерация нового массива элементов
        for (int i = 0; i < bykvas.length; i++){
            for (int j = chars.length - 1; j >= 2; j -= 3){
                if (chars[j - 2].equals(bykvas[i])){
                    new_chars.add(chars[j - 2]);
                    new_chars.add("=");
                    new_chars.add(chars[j]);
                    if (i != bykvas.length - 1)
                        new_chars.add("&");
                    break;
                }
            }
        }
        String result = ""; //Финальная строка
        for (int i = 0; i < new_chars.size(); i++){
            result += new_chars.get(i);
        }
        return result;
    }
    //Проверка наличия параметров
    public static boolean has(String URL){
        if (URL.indexOf('?') != -1)
            return true;
        return false;
    }
    //
    public static void stripUrlParams(String URL, String[] letters){
        if (has(URL)){
            System.out.println(URL.substring(0, URL.indexOf("?") + 1) + deleting(URL, letters));
        }
        else{
            System.out.println(URL);
        }
    }
}
