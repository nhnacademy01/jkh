package day10;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class LambdaExample {
    public static void main(String[] args) {
        LambdaExample e = new LambdaExample();
        e.before();

    }

    private void before() {
        List<String> names = Arrays.asList("jordan", "coco", "comtin", "manty");
//        names.replaceAll(new UnaryOperator<String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        });//lambda 식이없을때 느낌
        names.replaceAll((s)-> s.toUpperCase());
        System.out.println(names);
    }
}
