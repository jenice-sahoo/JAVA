import java.util.Scanner;

class EmployeePayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String idInput = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String salaryInput = sc.nextLine();

        System.out.print("Enter Bonus: ");
        String bonusInput = sc.nextLine();

        try {
            // Converting String values into Wrapper Objects
            Integer employeeId = Integer.valueOf(idInput);
            Double basicSalary = Double.valueOf(salaryInput);
            Double bonus = Double.valueOf(bonusInput);

            // Validation
            if (employeeId <= 0) {
                System.out.println("Invalid Employee ID.");
            } else if (basicSalary < 0 || bonus < 0) {
                System.out.println("Salary and bonus cannot be negative.");
            } else {
                Double netSalary = basicSalary + bonus;

                System.out.println("\nEmployee ID: " + employeeId);
                System.out.println("Basic Salary: ₹" + basicSalary);
                System.out.println("Bonus: ₹" + bonus);
                System.out.println("Net Salary: ₹" + netSalary);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid numeric values.");
        }

        sc.close();
    }
}