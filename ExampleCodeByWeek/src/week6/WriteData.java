package week6;

public class WriteData {
  public static void main(String[] args) throws java.io.IOException {
    java.io.File file = new java.io.File("C:\\GitHub\\cs141\\ExampleCodeByWeek\\src\\week6\\scores.txt");
    if (file.exists()) {
      System.out.println("File already exists");
      System.exit(1);
    }

    // Create a file
    java.io.PrintWriter output = new java.io.PrintWriter(file);

    // Write formatted output to the file
    output.print("John T. Perez ");
    output.println(90);
    output.print("Jamal K. Johnson ");
    output.println(85);

    // Close the file
    output.close();
  }
}