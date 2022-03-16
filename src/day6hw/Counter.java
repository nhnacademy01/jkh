package day6hw;

import java.util.ArrayList;
import java.util.Random;

public class Counter {

    private int totalItemPrice;
    private Coupon coupon = new Coupon();

    public Counter(){
    }

    public int dcPrice(int totalItemPrice){

        //int customerMoney= 20_000;
        double calculation=1;
        if(coupon.havePercent >=1) {
            calculation = totalItemPrice * coupon.percent;
            coupon.havePercent --;
        }
        if(coupon.haveWon1000 >= 1) {
            if (calculation > 1000) {
                calculation -= coupon.won1000;
            }
            coupon.haveWon1000--;
        }
        RandomCoupon();
        return totalItemPrice - (int)calculation;
    }
    private void RandomCoupon(){
        Random r = new Random();
        int choice = r.nextInt(2);
        if(choice == 0)
        {
            coupon.haveWon1000 ++;
        }
        else
        {
            coupon.havePercent ++ ;
        }
    }
    class Coupon {
        Double percent = 0.9;
        int won1000 = 1000;
        int havePercent = 1;
        int haveWon1000 = 1;
    }


}
