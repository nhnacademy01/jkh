import java.util.Scanner;
class function {
    public void unicode(){
        Scanner sc = new Scanner(System.in);
        System.out.println("문자를 입력하세요.");
        if (sc.hasNext()) {
            String line = sc.next();
            int temp = (int) line.charAt(0);
            System.out.printf("\\u%x", temp);
        }
    }
    public void namecord(){
            String   name =null;
            String  email =null;
            String  mobile =null;
            Scanner sc = new Scanner(System.in);
        System.out.println("input name : ");
        if (sc.hasNext()) {
            name = sc.next();
        }

        if (sc.hasNext()) {
            System.out.println("input email : ");
            email = sc.next();
        }

        if (sc.hasNext()) {
            System.out.println("input mobile : ");
            mobile = sc.next();
        }


        System.out.println(String.format("  name : %10s", name));
        System.out.println(String.format(" email : %10s", email));
        System.out.println(String.format("mobile : %10s", mobile));
        }
        public void inchtocm(){
            Scanner sc = new Scanner(System.in);
            System.out.println("cm으로 변경할 inch를 입력하세요.");
            int inch = sc.nextInt();
            System.out.printf("%d inch는 %.2f cm입니다.%n", inch, inch * 2.54f);

            System.out.println("inch으로 변경할 cm를 입력하세요.");
            int cm = sc.nextInt();
            System.out.printf("%d cm는 %.2f inch입니다.%n", cm, cm / 2.54f);
        }
        public  void swap(){
            int a = 10, b = 20;
            //int tmp; // 제거
            System.out.println("a: " + a + ", b: " + b);

            a = a +b;
            b = a - b ;
            a = a-b;
            System.out.println("After swap. a: " + a + ", b: " + b);
        }
}


public class Ex10 {

    public static void main(String[] args) {
        function fn = new function();
        fn.unicode();
        fn.namecord();
        fn.inchtocm();
        fn.swap();
        }
    }

