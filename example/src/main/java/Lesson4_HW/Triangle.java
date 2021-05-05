package Lesson4_HW;

public class Triangle {
    int a;
    int b;
    int c;
    double p;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static double getArea(int a, int b, int c) {
        double p = (a + b + c) / 2.0; // вычисление полупериметра треугольника
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c)); // формула Герона
        return s;
    }

}
