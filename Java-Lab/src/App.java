public class App {
    String name;
    int prn;
    double cgpa;
    float sgpa;

    App() {
        name = "";
        prn = 1;
        cgpa = 1.0;
        sgpa = 1.0f;
    }

    App(String n, int p) {
        name = n;
        prn = p;
        cgpa = 7.0;
        sgpa = 8.3f;
    }

    App(App a) {
        name = a.name;
        prn = a.prn;
        cgpa = a.cgpa;
        sgpa = a.sgpa;
    }

    void print() {
        System.out.println("Name: " + name);
        System.out.println("prn: " + prn);
        System.out.println("cgpa: " + cgpa);
        System.out.println("sgpa: " + sgpa);
    }

    public static void main(String[] args) {
        App obj1 = new App();
        obj1.print();

        App obj2 = new App("Jen", 1);
        obj2.print();

        App obj3 = new App(obj2);
        obj3.print();
    }
}