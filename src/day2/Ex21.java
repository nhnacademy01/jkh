package day2;

import java.util.Random;

public class Ex21 {
    public static void main(String[] args) {
        final int size = 5;
        boolean[][] canvas = new boolean[size][size];
        Random random = new Random();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = random.nextBoolean();
            }
        }
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }
}
