package day2;

public class Ex12 {
    public static void main(String[] args) {
        Ex12 i = new Ex12();
        //i.showfor(5);
        i.showfor2(5);
    }
    void showfor(int size){
        for(int i =0;i<size;i++){
            for(int j = 0 ; j<i;j++){
                System.out.printf("*");
            }
            System.out.println('\n');

        }
    }void showfor2(int size){
        for(int i =0;i<size;i++){
            for(int j = 0 ; j<i;j++){
                System.out.printf(" ");
            }
            System.out.printf("2");
            for(int k =size-1;k>i;k)
            {
                System.out.printf(" ");
            }System.out.println("*");


        }
    }
}
