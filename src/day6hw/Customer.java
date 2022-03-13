package day6hw;

public class Customer {
    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    public BuyList getBuyList() {
        return buyList;
    }

    public Basket getBasket() {
        return basket;
    }
    public void pickFoods(FoodStand foodStand){
        //todo basket = foodstand - buylist !!

        for (int i = 0; i < buyList.getItems().size(); i++) {
            String tempName = buyList.getItems().get(i).getName();
            int index = foodStand.getFoods().indexOf(tempName);
            int account = buyList.getItems().get(i).getAmount();
            int price = foodStand.getFoods().get(index).getPrice();
            basket.add(new Food(tempName,account * price));
        }
    }
    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    public void payTox(Counter counter) {
        //todo 결제과정 처리
        int tempPrice =0;
        int sizeBasket = basket.getFoods().size();
        for (int i = 0; i < sizeBasket; i++) {
            tempPrice += basket.getFoods().get(i).getPrice();
        }
        System.out.println("총 가격은 "+tempPrice+"입니다.");
        System.out.println("할인 후 잔액: "+counter.dcPrice(tempPrice) + "원입니다. 고맙습니다.");
        int balance = 20_000 -counter.dcPrice(tempPrice);
        System.out.println("고객님 결제 후 잔액: " + balance);
    }
}
