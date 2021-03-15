package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class t65 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String s = reader.readLine();
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) + "").equals(","))
                newString += s.charAt(i);
        }
        String[] splits = newString.split(" ");
        getHashTags(splits);
    }

    public static int kolvo(int[] counts, int k) {
        int count = 0;
        for (int j : counts) {
            if (j == k)
                count += 1;
        }
        return count;
    }

    public static String getFirst(String[] splits, int k) {
        String[] Sarr = splits;
        for (String value : Sarr) {
            if (value.length() == k)
                return value;
        }
        return "";
    }

    public static String getSecond(String[] splits, int k) {
        String[] Sarr = splits;
        int count = 0;
        for (String value : Sarr) {
            if (value.length() == k) {
                count += 1;
                if (count == 2)
                    return value;
            }
        }
        return "";
    }

    public static String getThird(String[] splits, int k) {
        String[] Sarr = splits;
        int count = 0;
        for (String value : Sarr) {
            if (value.length() == k) {
                count += 1;
                if (count == 3)
                    return value;
            }
        }
        return "";
    }

    public static void getHashTags(String[] splits) {
        String[] Sarr = splits;
        int max = 0;
        StringBuilder result = new StringBuilder();
        for (String value : Sarr) {
            if (value.length() > max) {
                max = value.length();
            }
        }
        int count = 0;
        int k = Sarr.length;
        int[] counts = new int[Sarr.length];
        for (int i = 0; i < k; i++) {
            counts[i] = Sarr[i].length();
        }
        if (k < 3) {
            while (count != k) {
                for (int i = 1; i <= kolvo(counts, max); i++) {
                    if (i == 1) {
                        result.append(getFirst(splits, max) + " ");
                    } else {
                        result.append(getSecond(splits, max) + " ");
                    }
                    count += 1;
                    if (count == k)
                        break;
                }
                max--;
            }
        } else {
            while (count != 3) {
                for (int i = 1; i <= kolvo(counts, max); i++) {
                    if (i == 1) {
                        result.append(getFirst(splits, max) + " ");
                        count += 1;
                        if (count == 3) {
                            break;
                        }
                    }else if (i == 2) {
                        result.append(getSecond(splits, max) + " ");
                        count += 1;
                        if (count == 3)
                            break;
                    } else {
                        result.append(getThird(splits, max) + " ");
                        count += 1;
                        if (count == 3)
                            break;
                    }
                }
                max--;
            }
        }
        String[] itog = result.toString().split(" ");
        for (int i = 0; i < itog.length; i++){
            itog[i] = "\"#" + itog[i].toLowerCase() + "\"";
        }
        System.out.println(Arrays.toString(itog));
    }
}

