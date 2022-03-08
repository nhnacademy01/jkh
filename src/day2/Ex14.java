package day2;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("> ");
            command = scanner.next();
            switch (command){
                case "dir":
                    System.out.println("디렉토리 목록을 출력합니다.");
                    break;
                case  "cp":
                    System.out.println("파일을 복사합니다.");
                    break;
                case  "quit":
                    System.out.println("(프로그램 종료)");
                    break;
                default:
                    System.out.println("존재하지 않는 명령어입니다.");
            }
        } while (!command.equals("quit"));

    }
}
