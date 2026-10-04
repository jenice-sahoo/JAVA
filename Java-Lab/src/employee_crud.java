package default_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class employee_crud {

public static void main(String[] args) {

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Anvi@1234";

try {
Connection con = DriverManager.getConnection(url, username, password);

Statement stmt = con.createStatement();

stmt.executeUpdate("DELETE FROM employees");

PreparedStatement insert = con.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?)");

insert.setInt(1, 1);
insert.setString(2, "Rahul");
insert.setString(3, "IT");
insert.setDouble(4, 45000);
insert.executeUpdate();

insert.setInt(1, 2);
insert.setString(2, "Priya");
insert.setString(3, "HR");
insert.setDouble(4, 50000);
insert.executeUpdate();

insert.setInt(1, 3);
insert.setString(2, "Aman");
insert.setString(3, "Finance");
insert.setDouble(4, 55000);
insert.executeUpdate();

System.out.println("CREATE OPERATION");
System.out.println("3 employee records inserted successfully.");
System.out.println();

displayEmployees(con);

PreparedStatement update = con.prepareStatement("UPDATE employees SET salary = ? WHERE employee_id = ?");

update.setDouble(1, 60000);
update.setInt(1, 2);
update.setInt(2, 2);
update.executeUpdate();

System.out.println("UPDATE OPERATION");
System.out.println("Employee ID 2 salary updated successfully.");
System.out.println();

displayEmployees(con);

PreparedStatement delete = con.prepareStatement("DELETE FROM employees WHERE employee_id = ?");

delete.setInt(1, 3);
delete.executeUpdate();

System.out.println("DELETE OPERATION");
System.out.println("Employee ID 3 deleted successfully.");
System.out.println();

displayEmployees(con);

System.out.println("READ OPERATION");
System.out.println("Remaining employee records retrieved successfully.");
System.out.println();

displayEmployees(con);

insert.close();
update.close();
delete.close();
stmt.close();
con.close();

} 
catch (Exception e) 
{
System.out.println(e);
}
}

public static void displayEmployees(Connection con) 
{

try {
Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

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

} 
catch (Exception e) 
{
System.out.println(e);
}
}
}
