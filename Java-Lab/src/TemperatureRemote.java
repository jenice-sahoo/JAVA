
import java.rmi.*;

public interface TemperatureRemote extends Remote {
    double celsiusToFahrenheit(double celsius)
            throws RemoteException;
}
