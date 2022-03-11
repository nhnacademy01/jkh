package day4;
class Dog1 extends Ex05{
    @Override
    public void cry(){
        System.out.println("Woof!");
    }
}
class Cat1 extends Ex05{
    @Override
    public void cry(){
        System.out.println("mee!");
    }
}
public class Ex05 {
    void cry(){
        return;
    }

    public static void main(String[] args) {
        Dog1 dog = new Dog1();
        Cat1 cat = new Cat1();
        dog.cry();
        cat.cry();
    }
}
