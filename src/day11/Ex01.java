package day11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex01 {
    private void practice(){
        List<String>messages = List.of("Welcome","NHN","Academy");
        int sum = messages.stream()
                .map(String::toUpperCase)
                .flatMapToInt(String::chars)
                .peek(c-> System.out.print(c+ " + "))
                .sum();
        System.out.println(sum);
    }
    private void sum(){
        IntStream intStream = IntStream.rangeClosed(1,100);
        int summ = intStream
                .filter(ii->ii%2 !=0)
                .peek(i-> System.out.print(i  +" + "))
                .sum();
        System.out.println(summ);
    }
    public static void main(String[] args) {
        Ex01 i = new Ex01();
        //i.practice();
        i.sum();
    }
}
