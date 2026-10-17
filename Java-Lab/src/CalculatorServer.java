
import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
             CalculatorRemote service = new CalculatorImpl();

            LocateRegistry.createRegistry(1099);
            Naming.rebind("CalculatorService", service);

            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
