package day6;

public class Ex01 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] sourecs = new String[]{"welcome", "to", "nhn", "academy.", "you", "are", "learning", "java", "now."};
        for (String source : sourecs) {
            if ("nhn".equals(source) || "java".equals(source)) {
                result.append(source);
            } else {
                result.append(source);
            }
            if (source.endsWith(".")) {
                result.append(System.lineSeparator());
            } else {
                result.append(" ");
            }
        }
        System.out.println(result);
    }
}
