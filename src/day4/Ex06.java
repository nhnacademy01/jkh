package day4;

class Vehicle1 {
    public Vehicle1() {
        super();
        System.out.println("Vehicle 생성");
    }
}
class Car1 extends Vehicle1{
    public Car1() {
        super();
        System.out.println("Car 생성");
    }
}
class SuperCar1 extends Car1 {
    public SuperCar1() {
        super();
        System.out.println("SuperCar 생성");
    }
}
public class Ex06 {
    public static void main(String[] args) {
        SuperCar1 scar = new SuperCar1();
    }
}
