package day4;

interface Flyable {
    void fly();
}
abstract class Animal1 {
    abstract void cry();
}
class Horse extends Animal1 {
    @Override
    public void cry() {
        System.out.println("히히힝~");
    }
}
//public class Pegasus {
//
//}
public class Ex10  extends Horse implements Flyable{

    @Override
    public void fly() {
        System.out.println("페가수스가 하늘을 날아갑니다.");
    }
    public static final void main(String[] args) {
        Ex10 horse = new Ex10();
        horse.fly();
        horse.cry();
    }}