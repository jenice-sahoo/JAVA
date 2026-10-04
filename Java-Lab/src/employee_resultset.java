package default_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class employee_resultset {

public static void main(String[] args) {

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Jen@1234";

try {

Connection con = DriverManager.getConnection(url, username, password);

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

System.out.println("Employee Records");
System.out.println("----------------------------------------");

while (rs.next()) {

System.out.println("Employee ID : " + rs.getInt("employee_id"));
System.out.println("Name : " + rs.getString("name"));
System.out.println("Department : " + rs.getString("department"));
System.out.println("Salary : " + rs.getDouble("salary"));
System.out.println("----------------------------------------");
}

rs.close();
stmt.close();
con.close();

} catch (Exception e) {
System.out.println(e);
}
}
}
