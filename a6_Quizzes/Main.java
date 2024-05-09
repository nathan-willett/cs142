// Define the classes based on your inheritance structure
class Gandalf {
    public void method1() {
        System.out.println("Gandalf 1");
    }

    public void method2() {
        System.out.println("Gandalf 2");
        method1();
    }
}

class Bilbo extends Gandalf {
    @Override
    public void method1() {
        System.out.println("Bilbo 1");
    }
}

class Frodo extends Bilbo {
    @Override
    public void method1() {
        System.out.println("Frodo 1");
        super.method1();
    }

    public void method3() {
        System.out.println("Frodo 3");
    }
}

class Gollum extends Gandalf {
    public void method3() {
        System.out.println("Gollum 3");
    }
}

public class Main {
    public static void main(String[] args) {
        Gandalf var1 = new Frodo();
        Gandalf var2 = new Bilbo();
        Gandalf var3 = new Gandalf();
        Bilbo var4 = new Bilbo();
        Bilbo var5 = new Frodo();
        Gandalf var6 = new Gollum();

        // Testing various method calls and casts
        try {
            System.out.println("Attempting to cast var4 (Bilbo) to Frodo and call method1:");
            ((Frodo) var4).method1(); // This should cause a ClassCastException at runtime if uncommented
        } catch (ClassCastException e) {
            System.out.println("Caught a ClassCastException as expected.");
        }

        // Other tests
        System.out.println("Calling method1 on var5 (actually Frodo):");
        var5.method1(); // Should successfully print "Frodo 1" followed by "Bilbo 1"

        System.out.println("Calling method3 on var1 (cast to Frodo):");
        ((Frodo) var1).method3(); // Should successfully print "Frodo 3"
    }
}
