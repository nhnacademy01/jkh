public class Ex07 {
    public static void main(String[] args) {
        String url = "nhnacademy.com";

        float f = 10.1f;
        double d = 1.23456789d;

        System.out.println("[12345678901234567890]");
        System.out.printf("[%s]%n", url);
        System.out.printf("[%20s]%n", url);
        System.out.printf("[%-20s]%n", url); // 왼쪽 정렬
        System.out.printf("[%.8s]%n", url);  // 왼쪽에서 8글자만 출력

        System.out.printf("f = %f, %e, %g%n", f, f, f);
        System.out.printf("d = %f%n", d);   // 마지막 자리 반올림
        System.out.printf("d = %15.10f%n", d);  // 전체(소수점 포함) 15자리 중 소수점 이하 10자리

        /////////////////////////////////

        byte b = 10;
        short s = 20;
        char c = 'C';
        int i = 55;
        long l = Long.MAX_VALUE;
        int hex = 0xFFFF_FFFF;
        int oct = 010;
        int binary = 0b1001;

        System.out.printf("b = %d%n", b);
        System.out.printf("s = %d%n", s);
        System.out.printf("c = %c, %d%n", c, (int)c);
        System.out.printf("i = [%5d]%n", i);
        System.out.printf("i = [%-5d]%n", i);
        System.out.printf("i = [%05d]%n", i);
        System.out.printf("hex = %x%n", hex);
        System.out.printf("hex = %#x%n", hex);  // #은 접두사
        System.out.printf("hex = %#X%n", hex);
        System.out.printf("oct = %#o, %d%n", oct, oct);
        System.out.printf("binary = %s, %d%n", Integer.toBinaryString(binary), binary);
    }
}
