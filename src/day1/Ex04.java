package day1;

public class Ex04 {
    public static void main(String[] args) {
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("min byte = " + minByte);
        System.out.println("max byte = " + maxByte);
        int minByteMinus1 = (int) (minByte - 1);
        int maxBytePlus1 = (int) (maxByte + 1);
        System.out.println("min byte - 1 = " + minByteMinus1);
        System.out.println("max byte + 1 = " + maxBytePlus1);
        long total = 20323242340320230L;//대문자로 붙여주기
        long total2 = 20_323_242_340_320_230L;
    }
}
