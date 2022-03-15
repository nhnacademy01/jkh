package day7;

import java.text.ChoiceFormat;

public class Ex06 {
    public static void main(String[] args) {
        Ex06 i = new Ex06();
        i.season();
    }

    private void season() {
        // n >= 0: F, n >= 60: D, n >= 70: C, n >= 80: B, n >= 90: A
        double[] minScores = {1, 3, 6, 9, 12};
        String[] seasons = {"겨울", "봄", "여름", "가을", "겨울"};
        ChoiceFormat gradesFormat = new ChoiceFormat(minScores, seasons);
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%d월의 계절은 %s%n",i,gradesFormat.format(i));
        }


    }
}
