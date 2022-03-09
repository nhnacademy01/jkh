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
        System.out.println("가위(1) 바위(2) 보(3) :" );
        Scanner sc = new Scanner(System.in);
        while (true) {
            int temp = 0;
            temp = sc.nextInt();
            switch (temp) {
                case 1:
                    System.out.println("당신은 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("당신은 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("당신은 보(3)입니다.");
                    break;
            }
            Random r = new Random();
            int computer = r.nextInt(3) + 1;
            switch (computer) {
                case 1:
                    System.out.println("컴퓨터는 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("컴퓨터는 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("컴퓨터는 보(3)입니다.");
                    break;
            }
            if (temp == computer) {
                System.out.println("비겼습니다. 다시 합니다.");
            } else if (temp + 1 == computer) {
                System.out.println("졌습니다.");
                break;
            } else if (temp == computer + 1) {
                System.out.println("이겼쓰ㅃ니따");
                break;
            }
        }
    }

    void lotto() {
        int [] lot = new int[6];
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            lot[i] = r.nextInt(45)+1;
            for (int j = 0; j <i ; j++) {

                if(lot[i]==lot[j]) {
                    i--;
                }
                }
            }
        }




    void card() {
        int [][] arr = new int[5][13];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <13 ; j++) {
                arr[i][j] = i +j;
            }
        }
        Random r = new Random();
        int size = 2;
        int [] joker = new int[size];
        int []arr1 = new int[size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j <2 ; j++) {
                int x = r.nextInt(5);
                int y = r.nextInt(13);
                if(x==4) {
                    joker[i] = 1;
                    System.out.println(x);
                }
                arr1[i] += arr[x][y];
            }
        }
        int max =0;

        for (int i = 0; i <size ; i++) {
            if(joker[i] == 1 ) {
                System.out.printf("win %c",'A'+i);
                return;
            }
            for (int j = 0; j < size ; j++) {
                if (max < arr1[j]) {
                    max = arr1[j];
                }

            }
            if(arr1[i] == max)
                System.out.printf("win %c",'A'+i);
        }
    }

    public static void main(String[] args) {
        Ex23 i = new Ex23();
        //i.add();
        // i.nusangi();
        //i.dice();
      //  i.card();

    }
}
