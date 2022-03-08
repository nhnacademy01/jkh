package day2;

public class Ex03 {
    public static void main(String[] args) {
        int score =11;
        int x = 6;
        char ch ='정';
        String str = "I am Hong";
        if (score >= 90 && score <= 100)
            System.out.println("A");
        if (score < 0 || score > 100)
            System.out.println("Not a score");
        if (x % 3 == 0 && x % 2 ==0)
            System.out.println("3의 배수면서 2의 배수");
        if (ch >= 'A' && ch <= 'Z')
            System.out.println("알파벳 대문자");
        if (str.equals("I am Hong"))
            System.out.println("I am Home");
        if (str.startsWith("I am"))
            System.out.println("I am ?");
    }
}
