package day2;

import java.util.Random;

public class Ex19 {
    public static void main(String[] args) {
        Ex19 i = new Ex19();
        i.sum();
        i.maxmin();
        i.sort();
    }

    void sum() {
        int sum = 0;
        float avg = 0.0f;

        int[] scores = {90, 75, 62, 80, 100};

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        avg = (float) sum / scores.length;

        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }

    void maxmin() {
        int[] scores = {90, 75, 62, 80, 100};

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }

    void sort() {
        int[] numbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20) + 1;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
