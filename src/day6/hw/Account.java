package day6.hw;

public class Account {
    private Money balance;
    private float interestRate;//이자

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
        return null;
    }
}


