package day2;

public class Ex11 {
    public static void main(String[] args) {
        for(int i =1; i<13;i++){
            printDaysInMonth(i);
        }
        for(int i = 'a';i<='z';i++)
        {
            System.out.println(i);
        }
        showAToZ();
    }
    private static void showAToZ(){
        for(int i = 'a';i<='z';i++)
        {
            System.out.printf("a" +i);
        }
    }
    private static void star01(){

    }
    private static void printDaysInMonth(int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println(month + " has 31 days.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + " has 30 days.");
                break;
            case 2:
                System.out.println(month + " has 28 or 29 days.");
                break;
            default:
                System.out.println(month + " is not a month.");
                break;
        }
    }
}
