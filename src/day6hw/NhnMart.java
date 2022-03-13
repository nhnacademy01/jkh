package day6hw;

import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList =  inputBuyListFromShell();

      Customer jordan = new Customer(buyList);
       // 장바구니를 챙긴다.
        jordan.bring(mart.provideBasket());
       // 식품을 담는다.
       jordan.pickFoods(mart.getFoodStand());
        // 카운터에서 계산한다.
       jordan.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // Scanner에서 buyList 만들기
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요(2종류만)");
        BuyList buyList = new BuyList();
//        buyList.add(new BuyList.Item("양파", 2));
//        buyList.add(new BuyList.Item("계란", 2));
//        buyList.add(new BuyList.Item("파", 1));
        // TODO scanner 버퍼문제 해결해안됨..
        Scanner sc = new Scanner(System.in);
        BuyList bl = new BuyList();
        String tempName = "";
        int tempCount =0;
        System.out.println("구매 물건과 수량을 입력해주세요");
        for (int i = 0; i < 2; i++) {
            tempName = sc.nextLine();
            sc.nextLine();
            tempCount = sc.nextInt();
            System.out.println(tempName +" | "+tempCount);
            bl.add(new BuyList.Item(tempName,tempCount));
            tempName = "";
            tempCount =0;
        }

        return bl;
        // return buyList;
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();
    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return foodStand;
    }
    public Counter getCounter() {
        return new Counter();
    }
}
