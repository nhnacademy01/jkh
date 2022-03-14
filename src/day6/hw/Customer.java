package day6.hw;

import java.util.ArrayList;

public class Customer {
    private Account account = new Account();
    private String customerName;

    public Customer(Account account, String customerName){
        this.customerName = customerName;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String getCustomerName() {
        return customerName;
    }
//    private void joinCustomer(){
//        for (int i = 0; i < 5; i++) {
//            accounts.add(new Account());
//
//        }
//    }
}
