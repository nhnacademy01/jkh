package day4.ex003;

public class Ex01 {
}
class ProtectedModifier {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColorAndSpeed("red", 20);
        System.out.println("color: " + car.getColor());
        System.out.println("speed: " + car.getSpeed());
    }
}
class Vehicle {
    private int speed;  // 자식 접근 불가
    protected String color; // 자식 접근 가능

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getColor() {
        return color;
    }
}
class Car extends Vehicle {
    public void setColorAndSpeed(String color, int speed) {
        this.color = color; // super.color = color;
        super.setSpeed(speed);
    }
}