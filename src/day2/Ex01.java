package day2;

public class Ex01 {
   public static boolean isSpring(int month) {
        return month >= 3 && month <= 5;
    }

    public static void main(String[] args) {
        int month =4;
        if(isSpring(month)){
            System.out.println("flowers bloom");
        }
    }



}
