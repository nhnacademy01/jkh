package day7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02 {
    public static void main(String[] args) {
        Ex02 i = new Ex02();
        i.satisfy();
    }
    public void satisfy(){
        Pattern p = Pattern.compile("^c.+");//c로 시작하는 문자열
        Matcher m = p.matcher("c");
        if(m.matches()){
            System.out.println("starts with 'c' ");
        }else{
            System.out.println("Not starts with 'c'");
        }
    }
}
