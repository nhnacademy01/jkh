package day5;

public class Food {
    private final String name;
    private final int price;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Food(String name, int price){
        this.name = name;
        this.price = price;
    }
}
