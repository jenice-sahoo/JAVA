package com.techcorp;

public class Main {
    public static void main(String[] args) {

        Employee manager = new Manager("Alice", 80000);
        Employee intern = new Intern("Bob", 30000);

        manager.displayEmployeeDetails();
        intern.displayEmployeeDetails();
    }
}