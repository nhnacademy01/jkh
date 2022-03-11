package day4.ex001;
//
//public class Ex01 {
//    public static void main(String[] args) {
//        Car car = new Car();
//        car.speed = 10;
//        System.out.println("speed = "+car.getSpeed());
//        System.out.println("VehicleSpeed = "+car.getVehicleSeepd());
//    }
//}
//class Vehicle{
//    int speed;
//    int getSpeed(){
//        return speed;
//    }
//}

//class Car extends Vehicle{
//    int speed;
//    int getVehicleSeepd(){
//        return this.speed;
//    }
//}
class Ex01 {
    public static void main(String[] args) {
        Car car = new Car();
        car.speed = 10;
        System.out.println("speed = " + car.getSpeed());
    }
}
class Vehicle  {
    int speed;

    int getSpeed() {

        return speed;   // this.speed
    }
}
class Car extends Vehicle{
    int speed; //상속하지 말고 지우면 정상 동작함
    @Override
    public int getSpeed(){
        return speed;
    }
}