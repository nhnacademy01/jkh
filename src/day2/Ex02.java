package day2;

public class Ex02 {
    public void  ifExpressions(){
        int month = 3;
        boolean isSpring = isSpring(month);

        if (isSpring);  // ??
        if (isSpring) System.out.println("It's warm");
        if (isSpring)
            System.out.println("The snow melts");
        if (isSpring) {
            System.out.println("Flowers bloom");
        }
        if (!isSpring) {
            System.out.println("Not spring");   // !
        }
    }

    private boolean isSpring(int month) {
        return month >= 3 && month <= 5;
    }

    public static void main(String[] args) {
        Ex02 i = new Ex02();
        i.ifExpressions();
    }
}
