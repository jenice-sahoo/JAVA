import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

class Course {
    String courseCode;
    String courseName;
    int credits;

    Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String toString() {
        return courseCode + " - " + courseName + " - " + credits + " credits";
    }
}

public class RegistrationSystem {

    static Vector<Course> availableCourses = new Vector<>();
    static ArrayList<Course> registeredCourses = new ArrayList<>();

    static void displayCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course c : availableCourses) {
            System.out.println(c);
        }
    }

    static void registerCourse(String code) {

        // Check duplicate
        for (Course c : registeredCourses) {
            if (c.courseCode.equalsIgnoreCase(code)) {
                System.out.println("Duplicate registration rejected");
                return;
            }
        }

        // Search available courses
        for (Course c : availableCourses) {
            if (c.courseCode.equalsIgnoreCase(code)) {
                registeredCourses.add(c);
                System.out.println("Course registered successfully");
                return;
            }
        }

        System.out.println("Course not found");
    }

    static void removeCourse(String code) {

        for (Course c : registeredCourses) {
            if (c.courseCode.equalsIgnoreCase(code)) {
                registeredCourses.remove(c);
                System.out.println("Course removed successfully");
                return;
            }
        }

        System.out.println("Course not registered");
    }

    static void searchCourse(String code) {

        for (Course c : registeredCourses) {
            if (c.courseCode.equalsIgnoreCase(code)) {
                System.out.println("Course found: " + c);
                return;
            }
        }

        System.out.println("Course not found");
    }

    static void generateSummary() {

        StringBuffer sb = new StringBuffer();

        int totalCredits = 0;

        sb.append("\n===== REGISTRATION SUMMARY =====\n");

        for (Course c : registeredCourses) {

            sb.append(c.courseCode)
              .append(" - ")
              .append(c.courseName)
              .append(" - ")
              .append(c.credits)
              .append(" credits\n");

            totalCredits += c.credits;
        }

        sb.append("Total Registered Courses: ")
          .append(registeredCourses.size())
          .append("\n");

        sb.append("Total Credits: ")
          .append(totalCredits)
          .append("\n");

        System.out.println(sb);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Vector: Available courses
        availableCourses.add(new Course("CS101", "Java Programming", 4));
        availableCourses.add(new Course("CS102", "Data Structures", 4));
        availableCourses.add(new Course("CS103", "Database Management", 3));
        availableCourses.add(new Course("CS104", "Operating Systems", 3));

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Search Registered Course");
            System.out.println("5. Generate Registration Summary");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:
                    System.out.print("Enter course code to register: ");
                    String code = sc.nextLine();
                    registerCourse(code);
                    break;

                case 3:
                    System.out.print("Enter course code to remove: ");
                    code = sc.nextLine();
                    removeCourse(code);
                    break;

                case 4:
                    System.out.print("Enter course code to search: ");
                    code = sc.nextLine();
                    searchCourse(code);
                    break;

                case 5:
                    generateSummary();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}