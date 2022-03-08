package day1;

public class Ex03 {
    public void bytes() {
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("min byte = " + minByte);
        System.out.println("max byte = " + maxByte);
        byte minByteMinus1 = (byte) (minByte - 1);
        byte maxBytePlus1 = (byte) (maxByte + 1);
        System.out.println("min byte - 1 = " + minByteMinus1);
        System.out.println("max byte + 1 = " + maxBytePlus1);
    }

    public static void main(String[] args) {
       Ex03 types = new Ex03();
        types.bytes();
    }
}
