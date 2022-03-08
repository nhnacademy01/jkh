package day2;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char[][] board = new char[3][3];
        int a = 0, b = 0;
        for (int i = 1; i <= 9; i++) {


            if (i % 2 == 0) {
                System.out.println("컴퓨터턴");
                    a = r.nextInt(3);

                b = r.nextInt(3);
                //show(a, b);
            } else {
                if (sc.hasNext()){
                    while (true){
                    a = sc.nextInt();
                    if(a>=0&&a<3)
                        break;
                    }
                }
                while (true){
                    b = sc.nextInt();
                    if(b>=0&&b<3)
                        break;
                }
                System.out.println("사용자턴 xy");
                //show(a, b);
            }
        }


    }

    static void show(char[][] board,int a, int b) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }

    static void paly_check(int a, int b) {

    }
}

public class Ex22 {
    public static void main(String[] args) {

    }
}
