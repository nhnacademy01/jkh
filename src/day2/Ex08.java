package day2;

public class Ex08 {
    public static void main(String[] args) {
        int memberGrade = 3;

        switch (memberGrade) {
            case 3:
                grantVip();
            case 2:
                grantGold();
            case 1:
                grantSilver();
                break;
            default:
                noBenefit();
        }
    }

    private static void grantVip() {
        System.out.println("Issue VIP coupons");
    }

    private static void grantGold() {
        System.out.println("Issue Gold coupons");
    }

    private static void grantSilver() {
        System.out.println("Issue Silver coupons");
    }

    private static void noBenefit() {
        // Nothing
        System.out.println("No coupons");
    }
}
