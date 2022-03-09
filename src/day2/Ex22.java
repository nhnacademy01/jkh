package day2;

import java.util.Random;
import java.util.Scanner;

public class Ex22 {
    static void show(char[][] board) {


        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char[][] board = new char[3][3];
        int a = 0, b = 0;
        boolean game = true;
        char playerwin = ' ';
        show(board);
        int ja = -1;
        while (game) {
            boolean user = true;
            boolean com = true;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = ' ';
                }
            }
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != ' ') {
                        count++;
                    }

                }
            }
            if (count == 8) {
                com = false;
            } else if (count == 9) {
                user = false;
            }
            while (user) {
                System.out.println("user ");
                while (true) {
                    a = sc.nextInt();
                    b = sc.nextInt();
                    if (a < 3 && a >= 0 && b < 3 && b >= 0) {
                        System.out.println("dsx");
                        break;
                    }

                }
                if (board[a][b] != ' ') {
                    System.out.println("xxxxffx");
                    continue;
                } else {
                    board[a][b] = '0';
                }

                while (com) {
                    System.out.println("computer");
                    ja = r.nextInt(8) + 1; //1이상 n이하의 무작위 정수
                    switch (ja) {
                        case 1:
                            a = 0;
                            b = 0;
                            break;
                        case 2:
                            a = 0;
                            b = 1;
                            break;
                        case 3:
                            a = 0;
                            b = 2;
                            break;
                        case 4:
                            a = 1;
                            b = 0;
                            break;
                        case 5:
                            a = 1;
                            b = 1;
                            break;
                        case 6:
                            a = 1;
                            b = 2;
                            break;
                        case 7:
                            a = 2;
                            b = 0;
                            break;
                        case 8:
                            a = 2;
                            b = 1;
                            break;
                        case 9:
                            a = 2;
                            b = 2;
                            break;
                    }

                    if (board[a][b] != ' ') {
                        continue;
                    } else {
                        board[a][b] = 'X';
                        break;
                    }

                }
                show(board);

            }
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == '0' && board[i][1] == '0' && board[i][2] == '0') ||
                        (board[0][i] == '0' && board[1][i] == '0' && board[2][i] == '0') ||
                        (board[0][0] == '0' && board[1][1] == '0' && board[2][2] == '0') ||
                        (board[2][0] == '0' && board[1][1] == '0' && board[0][2] == '0')) {
                    playerwin = 'y';
                    game = false;
                    break;
                }
                if ((board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') ||
                        (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') ||
                        (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                        (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')) {
                    playerwin = 'n';
                    game = false;
                    break;
                }
            }

        }

        if (playerwin == 'y') {
            System.out.println("플레이어 승리!");
        } else if (playerwin == 'n') {
            System.out.println("컴퓨터 승리!");
        } else {
            System.out.println("비겼습니다!");
        }


    }

}




