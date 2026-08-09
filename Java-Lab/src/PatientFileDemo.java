import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PatientFileDemo {
    public static void main(String[] args) {

        try {
            // Writing patient details to file
            FileWriter writer = new FileWriter("patient.txt");

            writer.write("Patient ID: 201\n");
            writer.write("Patient Name: Sarah\n");
            writer.write("Age: 25\n");
            writer.write("Diagnosis: Fever\n");

            writer.close();

            // Reading patient details from file
            FileReader reader = new FileReader("patient.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;

            System.out.println("Patient Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}