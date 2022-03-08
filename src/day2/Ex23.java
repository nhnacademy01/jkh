package day2;

import java.util.Random;
import java.util.Scanner;

public class Ex23 {
    int add() {
        System.out.println("어떤 연산을 하실건가요? (+,-,*,/)");
        Scanner sc = new Scanner(System.in);
        String s = "";
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

        int get =add();

        while(true){
            System.out.println("어떤 연산을 하실건가요? (+,-,*,/)");
            Scanner sc = new Scanner(System.in);
            String s = "";
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
        }


    }

    void dice() {
        int size =2;
        int [] arr = new int[size];//사람수
        Random r = new Random();
        for (int i = 0; i <size ; i++) {
          arr[i] =  r.nextInt(6)+1;
        }
        int win =-1;
        int temp =1;
        for(int j = 0;j<size ;j++){
            if(temp<arr[j])
            {
                temp = arr[j];
                win =j;
            }
        }

    }

    void gbb() {

    }

    void lotto() {

    }

    void card() {

    }

    public static void main(String[] args) {
        Ex23 i = new Ex23();
        i.add();
        i.nusangi();
    }
}
