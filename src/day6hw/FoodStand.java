package day6hw;

import java.util.ArrayList;

public class FoodStand {
    public ArrayList<Food> getFoods() {
        return foods;
    }

    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food onion1) {
        foods.add(onion1);
    }



}
