package day2;

public class Ex04 {
    void elesExp() {
        int score = 101;
        if (score >= 0 && score <= 100) {   // 조건을 만족하면 아래 블럭 호출
            System.out.println("It's a score");
        } else {                            // if 조건을 만족하지 않으면 아래 블럭 호출
            System.out.println("Not a score");
        }

        if (score >= 0 && score <= 100) System.out.println("It's a score");
        else System.out.println("Not a score");

        if (score >= 0 && score <= 100)
            System.out.println("It's a score");
        else
            System.out.println("Not a score");
    }

    public static void main(String[] args) {
        Ex04 i = new Ex04();
        i.elesExp();

    }
}
