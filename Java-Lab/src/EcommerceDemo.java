interface ProductOperations {
    void displayDetails();
    double calculatePrice();
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Electronic extends Product implements ProductOperations {
    Electronic(String name, double price) {
        super(name, price);
    }

    public void displayDetails() {
        System.out.println("Electronic Product: " + name);
        System.out.println("Price: " + price);
    }

    public double calculatePrice() {
        return price + (price * 0.18);
    }
}

class Clothing extends Product implements ProductOperations {
    Clothing(String name, double price) {
        super(name, price);
    }

    public void displayDetails() {
        System.out.println("Clothing Product: " + name);
        System.out.println("Price: " + price);
    }

    public double calculatePrice() {
        return price + (price * 0.05);
    }
}

class Grocery extends Product implements ProductOperations {
    Grocery(String name, double price) {
        super(name, price);
    }

    public void displayDetails() {
        System.out.println("Grocery Product: " + name);
        System.out.println("Price: " + price);
    }

    public double calculatePrice() {
        return price + (price * 0.02);
    }
}

public class EcommerceDemo {
    public static void main(String[] args) {

        ProductOperations p1 = new Electronic("Laptop", 50000);
        ProductOperations p2 = new Clothing("T-Shirt", 1000);
        ProductOperations p3 = new Grocery("Rice", 500);

        p1.displayDetails();
        System.out.println("Final Price = " + p1.calculatePrice());

        System.out.println();

        p2.displayDetails();
        System.out.println("Final Price = " + p2.calculatePrice());

        System.out.println();

        p3.displayDetails();
        System.out.println("Final Price = " + p3.calculatePrice());
    }
}