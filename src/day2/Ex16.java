package day2;

import java.util.Random;
import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int number =0;
        String t ="";
        int result20 = r.nextInt(20) + 1;  // 1~20
        do{
            System.out.println("숫자를 맞춰주세요. (1~20):");

            number = sc.nextInt();
            if(number > result20)
                t="더작은 값을 입력해주세요";
            if(number < result20)
                t="더큰값을 입력해주세요";
            if(number == result20) {
                t = "정답입니다.";
                System.out.println(t);
                return;
            }

            System.out.println(t);
        }while (true);
    }
}
