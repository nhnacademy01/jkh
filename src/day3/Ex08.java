package day3;

public class Ex08 {
    public static void main(String[] args) {
        Mooney amt1 = new Mooney(1_000, "WON");
        Mooney amt2 = new Mooney();
        amt2.amount = 2_000;
        amt2.currency = "DOLLAR";

        System.out.printf("amt1 = %d %s%n", amt1.amount, amt1.currency);
        System.out.printf("amt2 = %d %s%n", amt2.amount, amt2.currency);
    }
}

class Mooney {
    long amount;
    String currency;

    public Mooney() {
    }

    public Mooney(long a, String c) {
        amount = a;
        currency = c;
    }
}