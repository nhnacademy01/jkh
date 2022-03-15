package day7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02 {
    public static void main(String[] args) {
        Ex02 i = new Ex02();
        i.satisfy();

        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        while (m.find()) {
            System.out.println("m.groupCount(): " + m.groupCount());
            System.out.println("m.group(): " + m.group());  // m.group(0)
            System.out.println("m.group(1): " + m.group(1));
            System.out.println("m.group(2): " + m.group(2));
        }
        i.replace();
        i.number();
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
    private void replace() {
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            String localPart = m.group(1);
            m.appendReplacement(result, localPart + "@nhnacademy.com");
        }
        m.appendTail(result);
        System.out.println(result);
    }
    private void number(){
        Pattern p = Pattern.compile("\\s(031)");
        Matcher m = p.matcher("032-0032-0320\n" +
                "032-0031-0311\n" +
                "031-031-0310\n" +
                "031-031-0322");
        StringBuffer result = new StringBuffer();
        while (m.find()){
            String localPart = m.group(1);
            m.appendReplacement(result,"\n032");
        }
        m.appendTail(result);
        System.out.println(result);
    }

}
