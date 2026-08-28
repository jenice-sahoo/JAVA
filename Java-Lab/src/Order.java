public class Order {
    int orderId;
    String customerName;
    String price;
    int quantity;
    int deliveryCharge;


    Order(int orderid, String customerName, String price, int quantity, int delieveryCharge) {
        this.orderId = orderid;
        this.customerName = customerName;
        this.price = price;
        this.quantity = quantity;
        this.deliveryCharge = deliveryCharge;
    }

    int calculateBill(int dprice) {
        int totalPrice = Integer.parseInt(price) * quantity + deliveryCharge;
        return totalPrice;
    }

    int calculateBill(String price, int quantity) {
        int totalPrice = Integer.parseInt(price) * quantity + deliveryCharge - discount;
        return totalPrice;
    }
}
