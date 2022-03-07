public class Ex09 {
    String name = "hong";
    String newName = new String("hong");

     System.out.printf("\"hong\" == \"hong\" ?\t %b%n", "hong" == "hong");
     System.out.printf("\"hong\" == name ?\t %b%n", "hong" == name);
     System.out.printf("\"hong\" == newName ?\t %b%n", "hong" == newName);
     System.out.printf("name == newName ?\t %b%n", name == newName);
     System.out.printf("\"hong\".equals(name) ?\t\t %b%n", "hong".equals(name));
     System.out.printf("\"hong\".equals(newName) ?\t %b%n", "hong".equals(newName));
     System.out.printf("name.equals(newName) ?\t\t %b%n", name.equals(newName));
}
