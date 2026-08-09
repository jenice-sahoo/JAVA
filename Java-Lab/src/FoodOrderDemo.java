abstract class FoodOrder {
    double foodPrice;

    FoodOrder(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    abstract double calculateBill();

    void displayPrice() {
        System.out.println("Food Price: " + foodPrice);
    }
}

class DineInOrder extends FoodOrder {

    DineInOrder(double foodPrice) {
        super(foodPrice);
    }

    double calculateBill() {
        double tax = foodPrice * 0.05;
        return foodPrice + tax;
    }
}

class TakeAwayOrder extends FoodOrder {

    TakeAwayOrder(double foodPrice) {
        super(foodPrice);
    }

    double calculateBill() {
        double packagingCharge = 50;
        double tax = foodPrice * 0.05;
        return foodPrice + tax + packagingCharge;
    }
}

public class FoodOrderDemo {
    public static void main(String[] args) {

        FoodOrder dineIn = new DineInOrder(500);

        System.out.println("Dine-In Order:");
        dineIn.displayPrice();
        System.out.println("Total Bill: " + dineIn.calculateBill());

        System.out.println();

        FoodOrder takeAway = new TakeAwayOrder(500);

        System.out.println("Take-Away Order:");
        takeAway.displayPrice();
        System.out.println("Total Bill: " + takeAway.calculateBill());
    }
}