import java.rmi.*;
import java.rmi.registry.*;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            TemperatureRemote service = new TemperatureImpl();

            LocateRegistry.createRegistry(1099);
            Naming.rebind("TemperatureService", service);

            System.out.println("Temperature Server is ready.");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}

