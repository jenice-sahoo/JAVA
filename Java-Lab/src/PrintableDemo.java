interface Printable {
    void print();
}

class Student implements Printable {
    public void print() {
        System.out.println("Student details");
    }
}

class Employee implements Printable {
    public void print() {
        System.out.println("Employee details");
    }
}

public class PrintableDemo {
    public static void main(String[] args) {
        Student s = new Student();
        Employee e = new Employee();

        s.print();
        e.print();
    }
}