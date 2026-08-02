class RestaurantBilling {
    static int totalOrders = 0;

    // Dine-in bill
    static double calculateBill(double foodAmount) {
        totalOrders++;
        return foodAmount;
    }

    // Takeaway bill with packing charges
    static double calculateBill(double foodAmount, double packingCharges) {
        totalOrders++;
        return foodAmount + packingCharges;
    }

    // Delivery bill with packing and delivery charges
    static double calculateBill(double foodAmount, double packingCharges,
                                double deliveryCharges) {
        totalOrders++;
        return foodAmount + packingCharges + deliveryCharges;
    }

    public static void main(String[] args) {
        System.out.println("Dine-in Bill: ₹" + calculateBill(500));

        System.out.println("Takeaway Bill: ₹"
                + calculateBill(500, 30));

        System.out.println("Delivery Bill: ₹"
                + calculateBill(500, 30, 50));

        System.out.println("Total Orders: " + totalOrders);
    }
}