package day3;

public class Ex01 {
    public static void main(String[] args) {
        System.out.println();
    }
}
class Account{
    public static void main(String[] args) {
        Account nhnAccount = new Account();
        nhnAccount.deposiit(1_000L);
        nhnAccount.withdraw(500L);
        System.out.println("amount = " + nhnAccount.getAmount());
    }
    private long amount = 0L;
    public void deposiit(long depositAmt){
        this.amount += depositAmt;
    }
    public void withdraw(long withdraw){
        this.amount -= withdraw;
    }
    public long getAmount(){
        return this.amount;
    }
}
