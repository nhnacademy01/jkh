package day2;

public class Ex06 {
    void elesIfToTriOperator(){
        int score =91;
        String grade;
        grade = score >= 90 ? "A":score >= 80 ? "B":"F";
        System.out.println(grade);
    }
    public static void main(String[] args) {
        Ex06 i = new Ex06();
        i.elesIfToTriOperator();
    }
}
