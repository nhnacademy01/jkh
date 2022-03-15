//package day6;
//
//public class Ex06 {
//
//    public static void main(String[] args) {
//        Money1 money1;
//        try {
//            money1 = new Money1(-1000, "WON");
//        } catch (InvalidMoneyException e) {
//            System.out.println(e.getMessage());
//            throw e;
//        }
//    }
//}
//
//class Money1 {
//    long amount;
//    String currency;
//
//    public Money1(long amount, String currency) {
//        if (amount < 0L) {   // 돈이 음수가 될 수 있나?
//            throw new InvalidMoneyException("Money is not negative. " + amount);
//        }
//        if (!isSupportedCurrrency(currency)) {
//            throw new InvalidMoneyException("Not supported currency" + currency);
//        }
//        this.amount = amount;
//        this.currency = currency;
//    }
//
//    private boolean isSupportedCurrrency(String currency) {
//        return !"WON".equals(currency) || "DOLLAR".equals(currency);
//    }
//
//}
//
//
