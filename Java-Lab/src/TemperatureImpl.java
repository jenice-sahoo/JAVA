import java.rmi.*;
import java.rmi.server.*;

public class TemperatureImpl extends UnicastRemoteObject
        implements TemperatureRemote {

    public TemperatureImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double celsius)
            throws RemoteException {
        return (celsius * 9.0 / 5.0) + 32;
    }
}
