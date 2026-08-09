import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeFileDemo {
    public static void main(String[] args) {

        try {
            // Writing employee details to file
            FileWriter writer = new FileWriter("employee.txt");

            writer.write("Employee ID: 101\n");
            writer.write("Employee Name: Minji\n");
            writer.write("Department: Computer Engineering\n");
            writer.write("Salary: 50000\n");

            writer.close();

            // Reading employee details from file
            FileReader reader = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;

            System.out.println("Employee Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}