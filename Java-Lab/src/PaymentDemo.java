abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract void makePayment();

    void displayAmount() {
        System.out.println("Payment Amount: " + amount);
    }
}

class CreditCard extends Payment {

    CreditCard(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment made using Credit Card.");
    }
}

class UPI extends Payment {

    UPI(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment made using UPI.");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {

        Payment p1 = new CreditCard(2500);
        p1.displayAmount();
        p1.makePayment();

        System.out.println();

        Payment p2 = new UPI(1500);
        p2.displayAmount();
        p2.makePayment();
    }
}