package day6.hw;

public class Account {
    private Money balance;

    public Money getBalance() {
        return balance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    private float interestRate;//이자

    public Account(Money balance, float interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // 입금
    public Money deposit(Money amount) {
        // 제약 조건
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    // 출금
    public Money withdrawal(Money amount) {
        // 제약 조건
        this.balance = this.balance.substract(amount);
        return this.balance;
    }

    // 이자 지급
    Money payInterest() {
        Money interest = cacluateInterest();
        this.balance = this.balance.add(interest);
        return this.balance;
    }

    private Money cacluateInterest() {
        // TODO
        return  new Money((long) (this.balance.getAmount()*this.getInterestRate()),this.balance.getCurrency());

    }
}


