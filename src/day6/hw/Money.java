package day6.hw;

public class Money {
    private long amount;
    private Currency currency;
    public Money(long amount,Currency currency){
        this.amount = amount;
        this.currency = currency;

    }
    public Money add(Money money) {
        //todo 통화 체크기능
       Money money1 = new Money(this.amount+money.amount,  money.currency);
        return money1;
    }

    public Money substract(Money amount) {
        Money money1 = new Money(this.amount-amount.amount, amount.currency);
        return money1;
    }//인출

    public enum Currency {
        WON, DOLLAR
    }

    public String toString() {
        return amount + " " + currency;
    }
}
