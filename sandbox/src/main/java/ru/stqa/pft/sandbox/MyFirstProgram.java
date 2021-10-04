package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    //main
    public static void main(String[] args) {
        System.out.println("Hello world");
        Point o = new Point(-1,-1);
        Point l = new Point(1,1);
        System.out.println("Расстояние между точками с координатами "+"("+o.x+","+o.y+")"+" и "+"("+l.x+","+l.y+")"+" равно "+o.distance(l));

    }


    }
