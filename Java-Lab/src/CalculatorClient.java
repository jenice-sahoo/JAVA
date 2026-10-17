
import java.rmi.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            CalculatorRemote c = (CalculatorRemote)
                Naming.lookup("rmi://localhost/CalculatorService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter two numbers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("Addition: " + c.add(a, b));
            System.out.println("Subtraction: " + c.subtract(a, b));
            System.out.println("Multiplication: " + c.multiply(a, b));
            System.out.println("Division: " + c.divide(a, b));

            sc.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
