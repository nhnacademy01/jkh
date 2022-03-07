public class Ex01 {
    String instanceVariable = "instance";
    static String CLASS_VARIABLE = "class";

    public static void main(String[] args) {
        System.out.println(Ex01.CLASS_VARIABLE);
        Ex01 vars = new Ex01();
        System.out.println(vars.instanceVariable);
        System.out.println(vars.CLASS_VARIABLE);
        vars.someMethod("parameter");
    }

    public void someMethod(String parameter) {
        String localVariable = "local";
        System.out.println("parameter: " + parameter);
        System.out.println("localVariable: " + localVariable);
    }
}
