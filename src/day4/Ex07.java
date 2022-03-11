package day4;

public class Ex07 {
    public static void main(String[] args) {
        Car2 car = new Car2();
        car.drive();
        car.speedUp();
        System.out.println("car speed: " + car.getSpeed());

        SuperCar2 scar = new SuperCar2();
        scar.drive();
        scar.speedUp();
        System.out.println("scar speed: " + scar.getSpeed());
        scar.boosterOn();
        System.out.println("scar speed: " + scar.getSpeed());
    }
}

class Vehicle2 {
    private int speed;

    void drive() {
        System.out.println("Drive Vehicle");
    }

    void speedUp() {
        speed++;
    }

    int getSpeed() {
        return this.speed;
    }
}

class Car2 extends Vehicle2 {
    Vehicle2 d;

    @Override
    void speedUp() {
        super.speedUp();
        super.speedUp();
    }
}

class SuperCar2 extends Car2 {
    public static final int MAX_SPEED = 300;

    @Override
    void speedUp() {
       // speed += 4;
        super.speedUp();
        super.speedUp();
    }

    void boosterOn() {
       // speed = MAX_SPEED;
    }
}