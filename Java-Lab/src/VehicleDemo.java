    interface Action {
    void performAction();
}

class Vehicle {
    private String name = "Car";
    private String model = "Honda City";

    class VehicleDetails {
        void display() {
            System.out.println("Vehicle Name: " + name);
            System.out.println("Vehicle Model: " + model);
        }
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();

        Vehicle.VehicleDetails details = v.new VehicleDetails();
        details.display();

        Action a = new Action() {
            public void performAction() {
                System.out.println("Vehicle is starting...");
            }
        };

        a.performAction();
    }
}