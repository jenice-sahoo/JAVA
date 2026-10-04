import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class stud_record 
{
 
    public static void main(String[] args) 
    {
 
        String url = "jdbc:mysql://localhost:3306/java_sample_db";
        String username = "root";
        String password = "Jen@1234";
 
        try 
        {
            Connection con = DriverManager.getConnection(url, username, password);
 
            System.out.println("Database connected successfully!");
 
            Statement stmt = con.createStatement();
 
            String query = "SELECT * FROM students";
 
            ResultSet rs = stmt.executeQuery(query);
 
            System.out.println("\nStudent Records");
            System.out.println("----------------------------------------");
 
            while (rs.next()) {
 
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                double marks = rs.getDouble("marks");
 
                System.out.println("ID     : " + id);
                System.out.println("Name   : " + name);
                System.out.println("Age    : " + age);
                System.out.println("Course : " + course);
                System.out.println("Marks  : " + marks);
 
                System.out.println("----------------------------------------");
            }
 
            rs.close();
            stmt.close();
            con.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
