import faculty.FacultyDetails;
import student.StudentDetails;

public class CollegeMain {
    public static void main(String[] args) {

        StudentDetails s = new StudentDetails();
        FacultyDetails f = new FacultyDetails();

        System.out.println("Student Details:");
        s.displayStudent();

        System.out.println();

        System.out.println("Faculty Details:");
        f.displayFaculty();
    }
}