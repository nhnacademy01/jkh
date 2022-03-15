package day7;

import java.math.BigInteger;

public class Ex05 {
    public static void main(String[] args) {
        BigInteger num0 = BigInteger.ZERO;  // 기본 상수
        BigInteger num1 = BigInteger.valueOf(Long.MAX_VALUE);   // long
        BigInteger num2 = new BigInteger("1234567890123456789012345");  // String
        BigInteger num3 = new BigInteger(new byte[]{0xf});  // byte[]

        System.out.println("num0: " + num0);
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("num3: " + num3);

        BigInteger bi11 = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger bi22 = BigInteger.ONE;
        System.out.printf("%d + %d = %d (BigInteger.add)%n", bi11, bi22, bi11.add(bi22));

        long l1 = Long.MAX_VALUE;
        long l2 = 1L;
        System.out.printf("%d + %d = %d (+)%n", l1, l2, l1 + l2);
       // System.out.printf("%d + %d = %d (Math.addExact)%n", l1, l2, Math.addExact(l1, l2));

        BigInteger bi1 = new BigInteger("12345678901234567890");
        BigInteger bi2 = new BigInteger("12345");

        System.out.printf("%d + %d = %d%n", bi1, bi2, bi1.add(bi2));
        System.out.printf("%d - %d = %d%n", bi1, bi2, bi1.subtract(bi2));
        System.out.printf("%d * %d = %d%n", bi1, bi2, bi1.multiply(bi2));
        System.out.printf("%d / %d = %d%n", bi1, bi2, bi1.divide(bi2));
        System.out.printf("%d %% %d = %d%n", bi1, bi2, bi1.remainder(bi2));
        BigInteger[] dar = bi1.divideAndRemainder(bi2);
        System.out.printf("%d / %d = %d(+%d)%n", bi1, bi2, dar[0], dar[1]);
        BigInteger bi3 = bi1.negate();
        System.out.printf("abs(%d) = %d", bi3, bi3.abs());

        Ex05 i = new Ex05();
        BigInteger result = i.factorial(BigInteger.valueOf(30));
        System.out.println("\n factorial 30 "+ result);

    }
    private BigInteger factorial(BigInteger value){
        if(value.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        return value.multiply(factorial(value.subtract(BigInteger.ONE)));
    }
}
