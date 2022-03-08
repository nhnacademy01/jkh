package day2;

import java.util.Random;
import java.util.Scanner;

public class Ex23 {
    int add() {
        System.out.println("어떤 연산을 하실건가요? (+,-,*,/)");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println("피연산자 2수를 입력하세요.");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = 0;
        switch (s) {
            case "+":
                result = a + b;
                System.out.printf("%d + %d = %d", a, b, result);
                break;
            case "-":
                result = a - b;
                System.out.printf("%d - %d = %d", a, b, result);
                break;
            case "*":
                result = a * b;
                System.out.printf("%d * %d = %d", a, b, result);
                break;
            case "/":
                result = a / b;
                System.out.printf("%d / %d = %d", a, b, result);
                break;

        }
        return result;
    }

    void nusangi() {

        int get = add();

        while (true) {


            System.out.println("어떤 연산을 하실건가요? (+,-,*,/)");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            System.out.println("피연산자 2수를 입력하세요.");
            int a = get;
            int b = sc.nextInt();
            int result = 0;
            switch (s) {
                case "+":
                    result = a + b;
                    System.out.printf("%d + %d = %d", a, b, result);
                    get = result;
                    break;
                case "-":
                    result = a - b;
                    System.out.printf("%d - %d = %d", a, b, result);
                    get = result;
                    break;
                case "*":
                    result = a * b;
                    System.out.printf("%d * %d = %d", a, b, result);
                    get = result;
                    break;
                case "/":
                    result = a / b;
                    System.out.printf("%d / %d = %d", a, b, result);
                    get = result;
                    break;

            }
        }


    }

    int [] diceSum(int dices,int hum) {

        int[][] arr = new int[dices][hum];//사람수
        int[] arr1 = new int[hum];
        Random r = new Random();
        for (int i = 0; i < hum; i++) {
            for (int j = 0; j < dices; j++) {
                arr[i][j] = r.nextInt(6) + 1;//더하기
            }
        }//주사위 던지기
        for (int i = 0; i < hum; i++) {
            for(int j =0;j< dices;j++)
            {
                arr1[i] += arr[i][j];
            }
        }//주사위 합구하기
        return arr1;
    }

    void dice() {
        int dices = 3;//주사위
        int hum = 3;//사람
        int []arr1 = diceSum(dices,hum);
        int win =-1;
        int temp = 1;
        for (int j = 0; j < hum; j++) {
            System.out.println(arr1[j]);
            if (temp < arr1[j]) {
                temp = arr1[j];
                win = j;//최대값 인덱스번호
            }
        }// 최대값 조회
        System.out.printf("승자 %c",('A'+win));
        for (int i = 0; i < hum; i++) {
            if(arr1[win] == arr1[i] && win != i)
            {
                System.out.printf(" %c",'A'+i);
            }
        }//무승부 조회!!

    }

    void gbb() {

    }

    void lotto() {

    }

    void card() {

    }

    public static void main(String[] args) {
        Ex23 i = new Ex23();
        //i.add();
        // i.nusangi();
        i.dice();
    }
}
