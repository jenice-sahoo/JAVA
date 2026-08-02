//ASSIGNMENT 1 Q2

class Mobile {
    String brand;
    String model;
    int storage;
    double price;

    Mobile() { // constructor
        brand = "Unknown";
        model = "Unknown";
        storage = 0;
        price = 0.0;
    }

    Mobile(String b, String m, int s, double p) { // constructor with 4 parameters
        brand = b;
        model = m;
        storage = s;
        price = p;
    }

    Mobile(Mobile m) { 
        brand = m.brand;
        model = m.model;
        storage = m.storage;
        price = m.price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Storage: " + storage + " GB");
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("Samsung", "Galaxy A34", 128, 15999);
        Mobile m3 = new Mobile(m2);

        System.out.println("Default Constructor:");
        m1.displayDetails();

        System.out.println("\nParameterized Constructor:");
        m2.displayDetails();

        System.out.println("\nCopy Constructor:");
        m3.displayDetails();
    }
}