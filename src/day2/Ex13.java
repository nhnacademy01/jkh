package day2;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =0;
        while (true){
            String input = sc.next();
            System.out.println(input);
            count++;
            if(count == 10)
            {
                break;
            }
        }
    }
}
