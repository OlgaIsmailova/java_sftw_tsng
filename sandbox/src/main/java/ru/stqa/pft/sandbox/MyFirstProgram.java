package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    //main
    public static void main(String[] args) {
        System.out.println("Hello world");
        Point o = new Point();

        o.x = 0;
        o.y = 0;

        Point l = new Point();
        l.x = 1;
        l.y = 1;

        System.out.println(distance(o, l));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
}