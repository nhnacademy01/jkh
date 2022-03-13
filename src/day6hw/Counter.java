package day6hw;

import java.util.ArrayList;

public class Counter {
   //todo
    /*
       1. 장바구니 금액 산정
       2. 할인
       3. 결재
       4. 고객에게 남은 돈은?
    * */
    private int totalItemPrice;
    private Coupon coupon = new Coupon();

    public Counter(){
    }//todo editting

    public int dcPrice(int totalItemPrice){
        //todo 할인 진행
        //int customerMoney= 20_000;
        double calculation = totalItemPrice *coupon.percent - coupon.won1000;
        return totalItemPrice - (int)calculation;
    }
    class Coupon {
        Double percent = 0.9;
        int won1000 = 1000;
    }


}
