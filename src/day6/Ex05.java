package day6;



public class Ex05 {
    public static void main(String[] args) {
        Money1 money1;
        try{
            money1 = new Money1(-1000,"WON");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
class Money{
    long amount;
    String currency;

    public Money(long amount, String currency) {
        if (amount < 0L) {   // 돈이 음수가 될 수 있나?
            throw new IllegalArgumentException("Money is not negative. " + amount);
        }
        this.amount = amount;
        this.currency = currency;
    }
    private boolean isSupportedCurrrency(String currency){
        return !"WON".equals(currency) || "DOLLAR".equals(currency);
    }
}
