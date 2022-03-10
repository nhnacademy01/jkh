package day3;

public class Ex06 {
    public static void main(String[] args) {
        Bicycle b1 = new Bicycle();
        System.out.println(b1.getNumberOfBicycles());
        System.out.println(Bicycle.getNumberOfBicycles());  // 이 방식을 더 선호한다.
    }
}
class Bicycle {
    private int id;
    private static int numberOfBicycles = 0;

    public Bicycle() {  // 생성자. 곧 배울거에요.
        id = ++numberOfBicycles;
    }

    public int getID() {
        return id;
    }

    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }
}