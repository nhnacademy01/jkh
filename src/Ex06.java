class PrimitiveTypes {
    int intDefault;
    byte byteDefault;
    short shortDefault;
    long longDefault;
    float floatDefault;
    double doubleDefault;
    char charDefault;
    boolean booleanDefault;

    public void defaultValues() {
        System.out.println("intDefault: " + intDefault);
        System.out.println("byteDefault: " + byteDefault);
        System.out.println("shortDefault: " + shortDefault);
        System.out.println("longDefault: " + longDefault);
        System.out.println("floatDefault: " + floatDefault);
        System.out.println("doubleDefault: " + doubleDefault);
        System.out.println("charDefault: " + charDefault + ": " + (int)charDefault);
        System.out.println("booleanDefault: " + booleanDefault);
    }
    }
public class Ex06 {

        public static void main(String[] args) {
            PrimitiveTypes types = new PrimitiveTypes();
            types.defaultValues();
        }
}
