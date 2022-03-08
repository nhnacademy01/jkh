package day2;

public class Ex18 {
    public static void main(String[] args) {
        level: for (int i = 2; i <= 9; i++) { // level이라는 label을 달았어요.
            for (int j = 1; j <= 9; j++) {
                if (j == 6) {
                    break level;
    //                break;
   //                 continue level;
//                    continue;
                }
                System.out.printf("%d * %d = %2d%n", i, j, i * j);
            }
            System.out.println("----------");
    }
}
}
