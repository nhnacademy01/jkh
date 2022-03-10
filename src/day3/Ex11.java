package day3;

public class Ex11 {
    long amount = 0L;
    String currency = "WON";
    static int count = 0;
    // 클래스 초기화 블럭
    static {
        System.out.println("클래스 초기화");
        count++;
    }
    // 인스턴스 초기화 블럭
    {
        System.out.println("인스턴스 초기화");
        amount = 10L;
        currency = "DOLLAR";
        count++;
    }
    public Ex11() {
        System.out.println("생성자");
        amount = 1L;
        currency = "GOLD";
        count++;
    }
    public static void main(String[] args) {
        System.out.println("main 실행");
        Ex11 money = new Ex11();
        System.out.printf("money = %d %s%n", money.amount, money.currency);
        System.out.printf("calling count = %d%n", count);
    }
}
