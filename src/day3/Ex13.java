package day3;

import java.util.*;
import java.util.Scanner;

class UserData {
    String name;
    String id;
    String pw;
    int[] state = new int[3];

    public UserData(UserData ud) {
        this.name = ud.name;
        this.id = ud.id;
        this.pw = ud.pw;
        this.state = ud.state;
    }

    public UserData() {
        this.name = null;
        this.id = null;
        this.pw = null;
        this.state[0] = 0;
    }

    public UserData(String name, String id, String pw, int[] state) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.state = state;// 비밀번호 오류 체크 비정상 0 정상 1 // 계정 잠김 2 // 기본 3 // 아디없음 4 // 아이디 중복 5
    }
}//자료구조

class UserAdd {

    private static List<UserData> ud = new ArrayList<UserData>();

    public UserAdd() {
        setUserDate();
    }

    public int[] setUserDate() {
        Scanner sc = new Scanner(System.in);

        String tempName = null;
        String tempId = null;
        String udTemp = null;
        String udTemp2 = null;
        int tempStateId = 3;
        int tempStatePw = 3;
        int tempStateName = 3;
        int[] temps = new int[3];
        if (sc.hasNext()) {
            System.out.println("아이디 > ");
            tempId = sc.nextLine();
            if (getIdCheck(tempId) == 1)
                tempStateId = 5;//중복임
            else {
                tempStateId = 4;
            }

        }
        if (sc.hasNext()) {

            System.out.println("비밀번호 > ");
            udTemp = sc.nextLine();
            System.out.println("비밀번호 확인 > ");
            udTemp2 = sc.nextLine();
            if (udTemp.equals(udTemp2)) {

                tempStatePw = 1;

            } else {
                tempStatePw = 0;
            }


        }
        if (sc.hasNext()) {
            System.out.println("닉네임 > ");
            tempName = sc.nextLine();
            tempStateName = 1;
        }
        if (tempStateId != 5 && tempStatePw != 0) {

            temps[0] = tempStateId;
            temps[1] = tempStatePw;
            temps[2] = tempStateName;
            ud.add(new UserData(tempName, tempId, tempName, temps));
            for (int i = 0; i < 3; i++) {
                temps[i] = 1;
            }
            return temps;
        } else {
            return temps;
        }
    }

    private int getIdCheck(String id) {
        if (ud.indexOf(id) != -1) {
            return 0;
        } else {
            return 1;
        }

    }

    public List<UserData> getUserList() {
        return ud;
    }

}

public class Ex13 {

    public Ex13() {

    }

    public static void menuShow() {
        System.out.println("nhn academy에 오신 것을 환영합니다. 아래에엇 메뉴를 선택하세요");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
    }

    public static int userMenuInput() {
        System.out.println('>');
        Scanner sc = new Scanner(System.in);
        int menuId = -1;
        if (sc.hasNext())
            menuId = sc.nextInt();

        return menuId;
    }

    public static String login() {
        System.out.println("로그인 해주세요");
        Scanner sc = new Scanner(System.in);
        UserAdd userList = new UserAdd();
        String userId = null;
        String userPw = null;
        int idErrorCount = 0;
        int[] temps = new int[2];
        List<UserData> tempUd = new ArrayList<UserData>();
        UserData tempset = new UserData();
        tempUd = userList.getUserList();

        for (int i = 0; i < 5; i++) {

            idErrorCount++;
            if (sc.hasNext()) {

                System.out.println("아이디 > ");
                userId = sc.nextLine();//사용자가 입력함
            }
            if (sc.hasNext()) {
                System.out.println("비밀번호 > ");
                userPw = sc.nextLine();
            }
            int userIdTemp = userList.getUserList().indexOf(userId);
            int userPwTemp = userList.getUserList().indexOf(userPw);
            if (userIdTemp != -1) {
                temps[0] = 0;
            } else if (userIdTemp >= 0) {
                temps[0] = 1;//아이디 성공
            } else if (userPwTemp != -1) {
                temps[1] = 0;
            } else if (userPwTemp >= 0) {
                temps[1] = 1;
            }
            int benTemp = tempUd.get(userIdTemp).state[0];
            if (benTemp == 2) {
                System.out.println("잠긴 계정입니다.");
                return null;
            }
            if (idErrorCount == 4) {
                // 2 ///
                int userListIndex1 = tempUd.indexOf(userId);
                tempset.state[0] = 2;
                tempUd.set(userListIndex1, tempset);
                return null;
            }
        }
        int userListSize = userList.getUserList().size();
        if (temps[0] == 1 && temps[1] == 1) { //일치하면
            //userList.getUserList().indexOf(userId);
            int userListIndex2 = tempUd.indexOf(userId);
            return tempUd.get(userListIndex2).name;

        } else {
            return null;
        }

    }

    public static void main(String[] args) {

        List<String> testList = new ArrayList<String>();

        UserAdd ua = new UserAdd();
        int[] temps = new int[3];
        while (true) {
            menuShow();
            int menuId = userMenuInput();
            switch (menuId) {
                case 0:
                    return;
                case 1:
                    temps = ua.setUserDate();
                    if (temps[0] == 1 && temps[1] == 1 && temps[2] == 1) {
                        System.out.println("회원가입에 성공하셨습니다. 이전메뉴로 돌아갑니다.");
                    } else {
                        System.out.print("회원가입에 실패하셧습니다.");
                        if (temps[0] == 5) {
                            System.out.println("아이디 중복");
                        } else if (temps[1] == 0) {
                            System.out.println("비밀번호 불일치");
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 2:
                    System.out.println("로그인 해주세요");
                    String checkLoign = login();
                    if (checkLoign != null) {
                        System.out.println(checkLoign + "님 환영합니다.");
                    } else {
                        System.out.println("다시 로그인 해주세요");
                    }
                    break;
                default:
                    System.out.println("메뉴값이 잘못입력하였습니다.");
                    return;
            }
        }


    }

}//회원가입 로그인
