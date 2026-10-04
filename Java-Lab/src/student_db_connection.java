package default_;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class student_db_connection {
 
public static void main(String[] args) {
 
String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Jen@1234";
 
try {
 
Connection con = DriverManager.getConnection(url, username, password);
 
if (con != null) {
System.out.println("Database Connection Status: SUCCESS");
System.out.println("Student database is connected successfully.");
}
 
con.close();
 
} catch (Exception e) {
System.out.println("Database Connection Status: FAILED");
System.out.println(e.getMessage());
}
}
}
