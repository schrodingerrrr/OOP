package com.company;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lab2 {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите координаты x,y,z для трех точек через пробел: ");
        String str = read.readLine();
        String[] StrArr = str.split(" ");
        if (StrArr.length != 9)
        {
            System.out.println("Ошибка ввода!");
            return;
        }

            Point3d Point1 = new Point3d(Double.parseDouble(StrArr[0]), Double.parseDouble(StrArr[1]), Double.parseDouble(StrArr[2]));
            Point3d Point2 = new Point3d(Double.parseDouble(StrArr[3]), Double.parseDouble(StrArr[4]), Double.parseDouble(StrArr[5]));
            Point3d Point3 = new Point3d(Double.parseDouble(StrArr[6]), Double.parseDouble(StrArr[7]), Double.parseDouble(StrArr[8]));

        if (Point1.comparePoint3d(Point2.getX(),Point2.getY(),Point2.getZ()) || Point2.comparePoint3d(Point3.getX(),Point3.getY(),Point3.getZ())
                || Point3.comparePoint3d(Point1.getZ(),Point1.getY(),Point1.getZ()))


        {
            System.out.println("Ошибка: одинаковые координаты заданных точек!");
        }
        else
            computeArea(Point1,Point2,Point3);

    }
    public static void computeArea(Point3d point1, Point3d point2,Point3d point3)
    {
        double a = point1.distanceTo(point2.getX(),point2.getY(),point2.getZ());
        double b = point2.distanceTo(point3.getX(),point3.getY(),point3.getZ());
        double c = point3.distanceTo(point1.getX(),point1.getY(),point1.getZ());
        double p = ((a+b+c)/2);
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.println("Площадь треугольника равна = " +String.valueOf(s));
    }

}


