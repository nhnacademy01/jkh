package day6.hw;

import java.util.ArrayList;

public class Customer {
    private Account account;
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

}
