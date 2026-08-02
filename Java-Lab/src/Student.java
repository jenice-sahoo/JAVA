//assignment 1 Q1

class Student {
    String name;
    int rollNo;

    Student() { //default constructor
        name = "Student";
        rollNo = 0;
    }

    Student(String n, int prn) { //contructor with 2 parameters (parametrized constructor)
        name = n;
        rollNo = prn;
    }

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Jenice", 163);

        System.out.println("Default Constructor:");
        s1.displayDetails();

        System.out.println("\nParameterized Constructor:");
        s2.displayDetails();
    }
}