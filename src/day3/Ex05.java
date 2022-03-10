package day3;

public class Ex05 {
    public static void main(String[] args) {
        //System.out.println(factorial(Integer.MAX_VALUE));
        System.out.println(whileFactorial(Integer.MAX_VALUE));
    }
    static int factorial(int n){
        if(n == 1){
            return  1;
        }
        return n * factorial(n-1);
    }
    static int whileFactorial(int n){
        int t =1;
        while(true)
        {
            if(n == 1)
            {
                break;
            }
            t *= n;
            n--;
        }
        return t;
    }
}
