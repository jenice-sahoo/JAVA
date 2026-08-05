    interface DeliveryStatus {
    void updateStatus();
}

class FoodOrder {
    private String customerName = "Jenice";
    private String foodItem = "Pizza";

    class OrderDetails {
        void displayOrder() {
            System.out.println("Customer Name: " + customerName);
            System.out.println("Food Item: " + foodItem);
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        FoodOrder order = new FoodOrder();

        FoodOrder.OrderDetails details = order.new OrderDetails();
        details.displayOrder();

        DeliveryStatus status = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Order is out for delivery.");
            }
        };

        status.updateStatus();
    }
}