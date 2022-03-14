package day6.hw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts = new ArrayList<>();
    Account openAccount(Customer customer, Money initMoney) {
        accounts.add()
    }

    public void payInterestOnAllAccounts() {
        for(Account account : accounts) {
            account.payInterest();
        }
    }

}
