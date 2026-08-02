public class Calculator {
    static int count = 0;

    void sum(int a, int b) {
        count++;
        System.out.println("Integer sum: " + (a + b));
    }

    void sum(double a, double b) {
        count++;
        System.out.println("Decimal sum: " + (a + b));
    }

    public static void main(String[] args) {
        Calculator obj = new Calculator();
        obj.sum(10, 20);
        obj.sum(12.5, 3.5);
        System.out.println("Total calculations: " + count);
    }
}