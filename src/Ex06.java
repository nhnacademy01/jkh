class PrimitiveTypes {
        int intDefault;


        public void defaultValues() {
            System.out.println("intDefault: " + intDefault);
        }
    }
public class Ex06 {

        public static void main(String[] args) {
            PrimitiveTypes types = new PrimitiveTypes();
            types.defaultValues();
        }
}
