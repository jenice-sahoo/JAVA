public class Main {
    void print(int a) {
        System.out.println(a);
    }
    static void print1(int a) {
        System.out.println(a);
    }
    void print(String str) {
        System.out.println(str);
    }
    public static void main(String[] args) {
        int a = 163;
        Main obj = new Main();
        obj.print(a);
        obj.print("hello");
        Main.print1(a);
    }
}
