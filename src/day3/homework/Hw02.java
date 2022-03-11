package day3.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw02 {
    void menuShow() {
        System.out.println("nhn academy에 오신 것을 환영합니다. 아래에 메뉴를 선택하세요");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
    }

    public static void main(String[] args) {
        Hw02 i = new Hw02();
        Register r = new Register();
        Scanner sc = new Scanner(System.in);
        while (true) {
            i.menuShow();
            int menuNumber = sc.nextInt();
            switch (menuNumber) {
                case 0:
                    System.out.println("종료합니다");
                    return;
                case 1:
                    r.register();
                    break;
                case 2:
                    r.login();
                    break;
                default:
                    System.out.println("xxxx");

            }
        }
    }
}

class Register {
    private List<UserData> ud = new ArrayList<>();

    void login() {
        Scanner sc = new Scanner(System.in);
        String tempId = null;
        String tempPw = null;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("로그인 해주세요");
            System.out.println("아이디 >");
            tempId = sc.nextLine();
            System.out.println("비밀번호 >");
            tempPw = sc.nextLine();
            count++;
            if (count == 4) {
                System.out.println("잠김!!");
                return;
            }
            for (UserData j : ud) {
                if (j.id.equals(tempId) && j.pw.equals(tempPw)) {
                    System.out.println(j.name + "님 환영합니다.");
                    return;
                } else {
                    System.out.println("아이디 혹은 비밀번호가 틀렸습니다.(다시 로그인 해주세요)");
                    break;
                }
            }

        }

    }

    boolean findId(String CheckId) {
        for (UserData i : ud) {
            if (i.id.equals(CheckId)) {
                return true; //중복발견
            }
        }
        return false;//중복 xx
    }

    int register() {
        Scanner sc = new Scanner(System.in);
        String tempName = null;
        String tempId = null;
        String tempPw = null;
        String tempPw2 = null;
        ErrorCode ec = new ErrorCode();
        System.out.println("회원가입을 해주세요");
        System.out.println("아이디 > ");
        tempId = sc.nextLine();
        if (tempId == null) {
            ec.nullCheck = 0;
        } else if (findId(tempId)) {
            ec.id = 0;
            System.out.println(ec.id);
        } else {
            ec.id = 1;//일단 정상
            ec.nullCheck = 1;
            System.out.println(ec.id);
        }
        System.out.println("비밀번호 > ");
        tempPw = sc.nextLine();
        System.out.println("비밀번호 확인 > ");
        tempPw2 = sc.nextLine();
        if (tempPw.equals(tempPw2)) {
            ec.pw = 1; // 정상
        } else {
            ec.pw = 0; // 비정상
        }
        System.out.println(ec.pw);
        System.out.println("닉네임 > ");
        tempName = sc.nextLine();
        if (tempName == null) {
            ec.name = 0;
        } else {
            ec.name = 1;
        }
        System.out.println(ec.name);
        System.out.println(ec.nullCheck);
        //-----------------------------//

        if (ec.nullCheck != 0 && ec.id != 0 && ec.pw != 0 && ec.name != 0) {
            ud.add(new UserData(tempName, tempId, tempPw, ec));
            System.out.println(ud.get(0).name);
            System.out.println("회원가입에 성공했습니다. 이전메뉴로 돌아갑니다.");
        }
        return 0;

    }


}
class UserData {
    String name;
    String id;
    String pw;
    ErrorCode ec;

    UserData(String name,
             String id,
             String pw,
             ErrorCode ec) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.ec = ec;
    }
}

class ErrorCode {
    int pw;
    int id;
    int name;
    int nullCheck;
}