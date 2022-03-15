package day6.hw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Customer> getCustomers() {
        return customers;
    }


    //고객이 작성해온 신청서 기반으로 추가해야..
    Account openAccount(Customer customer, Money initMoney) {
       Account temp = new Account(customer.getAccount().getBalance().add(initMoney),customer.getAccount().getInterestRate());
        //accounts.add(temp);
        return temp;
    }//고객정보 조회
    public Bank(){
        joinAccounts();
    }

    private void joinAccounts(){
        Account tempBank1 = new Account(new Money(10000,Money.Currency.WON),6.5f);
        Account tempBank2 = new Account(new Money(10000,Money.Currency.WON),6.5f);
        Account tempBank3 = new Account(new Money(10000,Money.Currency.DOLLAR),6.5f);
        Account tempBank4 = new Account(new Money(10000,Money.Currency.WON),6.5f);
        Account tempBank5 = new Account(new Money(10000,Money.Currency.WON),6.5f);


        Customer tempCustomer1 = new Customer(tempBank1,"kihun");
        Customer tempCustomer2 = new Customer(tempBank2,"kin");
        Customer tempCustomer3 = new Customer(tempBank3,"kun");
        Customer tempCustomer4 = new Customer(tempBank4,"hun");
        Customer tempCustomer5 = new Customer(tempBank5,"hung");


        customers.add(tempCustomer1);
        customers.add(tempCustomer2);
        customers.add(tempCustomer3);
        customers.add(tempCustomer4);
        customers.add(tempCustomer5);

        accounts.add(tempBank1);
        accounts.add(tempBank2);
        accounts.add(tempBank3);
        accounts.add(tempBank4);
        accounts.add(tempBank5);

    }

    public void payInterestOnAllAccounts() {
        for(Account account : accounts) {
            account.payInterest();
        }
    }//이자 지급하는 함수

}
