package day3;

public class Ex02 {
    public static void main(String[] args) {

    }
}
/*
class Hammer {
    String model;
    int number;
    static int weight = 2_000;

    public static void main(String[] args) {
        System.out.println("weight = " + Hammer.weight);

        Hammer h1 = new Hammer();
        h1.model = "h1";
        h1.number = 1;

        Hammer h2 = new Hammer();
        h2.model = "h2";
        h2.number = 10;

        System.out.println("h1: " + h1.model + ", " + h1.number + ", " + h1.weight);
        System.out.println("h2: " + h2.model + ", " + h2.number + ", " + h2.weight);

        h2.number = 11;
        h2.weight = 1_000;

        System.out.println("h1: " + h1.model + ", " + h1.number + ", " + h1.weight);
        System.out.println("h2: " + h2.model + ", " + h2.number + ", " + h2.weight);

    }
    private static void printHammer(Hammer h1, String name){
        System.out.println(name + ": "+ h1.model + ", " + h1.number + ", " + h1.weight);
    }
}*/

class Hammer {
    String model;
    int number;
    static int weight = 2_000;

    public void print(String name) {
        System.out.println(name + ": " + model + ", " + number + ", " + weight);
    }

    public static void main(String[] args) {
        System.out.println("weight = " + Hammer.weight);

        Hammer h1 = new Hammer();
        h1.model = "h1";
        h1.number = 1;

        Hammer h2 = new Hammer();
        h2.model = "h2";
        h2.number = 10;

        h1.print("h1");
        h2.print("h2");

        h2.number = 11;
        h2.weight = 1_000;

        h1.print("h1");
        h2.print("h2");
    }
}