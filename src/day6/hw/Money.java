package day6.hw;

public class Money {
    private long amount;

    public long getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    private Currency currency;
    public Money(long amount,Currency currency){
        this.amount = amount;
        this.currency = currency;

    }
    public Money add(Money money) {
        //todo 통화 체크기능 마무리하기
        if(currency.equals(money.currency)) //예외 확인
            return new Money(this.amount+money.amount,  money.currency);
        else
            //throw e;  //예외 던지기
        return money;
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
