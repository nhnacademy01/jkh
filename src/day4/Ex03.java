package day4;

import java.awt.*;

class Point {
    int x;
    int y;
    public Point(){
        x=0;
        y=0;
    }
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Square extends Point{
    Point position;
    int width;
    public Square(int x, int y, int width){
        this.position =new Point(x ,y);
        this. width = width;
    }public int getArea(){
        return width*width;
    }
}
class Triangle extends Ex03 {
    Point position;
    int width;
    public Triangle(int x, int y,int width){
        this.position = new Point(x,y);
        this.width = width;
    }public int getArea(){
        return width * position.y / 2;
    }
}
class Rectangle extends Ex03{
    Point position;
    int width;
    public Rectangle(int x, int y,int width){
        this.position = new Point(x,y);
        this.width = width;
    }
    public int getArea(){
        return position.x * position.y;
    }
}

public class Ex03 {
    public static void main(String[] args) {

    }
    public int getArea(){
        return 0;
    }
}
