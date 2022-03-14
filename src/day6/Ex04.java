package day6;

public class Ex04 {
    int i1001_10_1 = Integer.parseInt("1001");
    int i1001_10_2 = Integer.valueOf("1001");
    int i1001_10_3 = Integer.parseInt("1001", 10);
    int i1001_10_4 = Integer.valueOf("1001", 10);
    int i1001_2_1 = Integer.parseInt("1001", 2);
    int i1001_2_2 = Integer.valueOf("1001", 2);
    int i1001_8_1 = Integer.parseInt("1001", 8);
    int i1001_8_2 = Integer.valueOf("1001", 8);
    int iAA_16_1 = Integer.parseInt("AA", 16);  // 10(A) * 16 + 10(A)
    int iAA_16_2 = Integer.parseInt("AA", 16);
//  int iAA_10 = Integer.parseInt("AA");  // 예외 발생z`
}
