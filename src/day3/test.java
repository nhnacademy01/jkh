package day3;

public class test {
    public void menuShow() {
        System.out.println("nhn academy에 오신 것을 환영합니다. 아래에엇 메뉴를 선택하세요");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
    }

    public static void main(String[] args) {
        test t =new test();
        t.menuShow();

    }
}
