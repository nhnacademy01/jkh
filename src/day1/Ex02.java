package day1;

class Swap{
    public void swqpfuntion(int a ,int b){
        int temp;//초기화 중요!!
        System.out.println("a: "+a+"b: "+b);
        temp =a;
        a =b;
        b = temp;
        System.out.println("a: "+a+"b: "+b);
    }
}
public class Ex02 {

    public static void main(String[] args) {
        Swap s = new Swap();
        s.swqpfuntion(10,20);
        int speed =0;
        System.out.println(speed);
    }
}
