package day6;

public class StringMethod {
    public static void main(String[] args) {
        System.out.println("\"NHN\".charAt(1): " + "NHN".charAt(1));
        System.out.println("\"NHN\".compareTo(\"ACADEMY\"): " + "NHN".compareTo("ACADEMY"));
        System.out.println("\"NHN\".compareTo(\"NHN\"): " + "NHN".compareTo("NHN"));
        System.out.println("\"ACADEMY\".compareTo(\"NHN\"): " + "ACADEMY".compareTo("NHN"));
        System.out.println("\"NHN\".concat(\"ACADEMY\"): " + "NHN".concat("ACADEMY"));
        System.out.println("\"NHN\".equals(\"ACADEMY\"): " + "NHN".equals("ACADEMY"));
        System.out.println("\"NHN\".equals(\"NHN\"): " + "NHN".equals("NHN"));
        System.out.println("\"NHN\".isEmpty(): " + "NHN".isEmpty());
        System.out.println("\"\".isEmpty(): " + "".isEmpty());
        System.out.println("\"NHN\".length(): " + "NHN".length());
        System.out.println("\"NHN\".toLowerCase(): " + "NHN".toLowerCase());
        System.out.println("\"nhn\".toUpperCase(): " + "nhn".toUpperCase());
    }
}
