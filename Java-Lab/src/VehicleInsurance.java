class Vehicle {
    String vehicleNumber;
    String vehicleType;

    Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    void displayVehicle() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

class CarInsurance extends Vehicle {
    double premium;

    CarInsurance(String vehicleNumber, String vehicleType, double premium) {
        super(vehicleNumber, vehicleType);
        this.premium = premium;
    }

    void displayInsurance() {
        super.displayVehicle();

        System.out.println("Insurance Type: Car Insurance");
        System.out.println("Insurance Premium: " + premium);
    }
}

class BikeInsurance extends Vehicle {
    double premium;

    BikeInsurance(String vehicleNumber, String vehicleType, double premium) {
        super(vehicleNumber, vehicleType);
        this.premium = premium;
    }

    void displayInsurance() {
        super.displayVehicle();

        System.out.println("Insurance Type: Bike Insurance");
        System.out.println("Insurance Premium: " + premium);
    }
}

public class VehicleInsurance {
    public static void main(String[] args) {

        CarInsurance car = new CarInsurance("MH12AB1234", "Car", 15000);
        BikeInsurance bike = new BikeInsurance("MH12XY5678", "Bike", 5000);

        System.out.println("Car Insurance Details:");
        car.displayInsurance();

        System.out.println();

        System.out.println("Bike Insurance Details:");
        bike.displayInsurance();
    }
}