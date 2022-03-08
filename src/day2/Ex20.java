package day2;

import java.util.Random;

public class Ex20 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random r = new Random();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(20) + 1;
            if (arr[i] <= 10) {
                // System.out.println(arr[i]);
                count++;
            }
        }


        System.out.println(count);
    }
}
