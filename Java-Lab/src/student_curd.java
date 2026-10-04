package default_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class student_curd {

public static void main(String[] args) {

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Anvi@1234";

try {
Connection con = DriverManager.getConnection(url, username, password);

Statement stmt = con.createStatement();

stmt.executeUpdate("DELETE FROM students");

PreparedStatement insert = con.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?)");

insert.setInt(1, 101);
insert.setString(2, "Anvi");
insert.setString(3, "Computer Science");
insert.setDouble(4, 88);
insert.executeUpdate();

insert.setInt(1, 102);
insert.setString(2, "Rahul");
insert.setString(3, "Information Technology");
insert.setDouble(4, 82);
insert.executeUpdate();

insert.setInt(1, 103);
insert.setString(2, "Sneha");
insert.setString(3, "Computer Engineering");
insert.setDouble(4, 91);
insert.executeUpdate();

System.out.println("CREATE OPERATION");
System.out.println("3 student records inserted successfully.");
System.out.println();

displayStudents(con);

PreparedStatement update = con.prepareStatement("UPDATE students SET marks = ? WHERE roll_no = ?");

update.setDouble(1, 95);
update.setInt(2, 101);
update.executeUpdate();

System.out.println("UPDATE OPERATION");
System.out.println("Marks of Roll No. 101 updated successfully.");
System.out.println();

displayStudents(con);

PreparedStatement delete = con.prepareStatement("DELETE FROM students WHERE roll_no = ?");

delete.setInt(1, 102);
delete.executeUpdate();

System.out.println("DELETE OPERATION");
System.out.println("Roll No. 102 deleted successfully.");
System.out.println();

displayStudents(con);

System.out.println("READ OPERATION");
System.out.println("Student records retrieved successfully.");
System.out.println();

displayStudents(con);

insert.close();
update.close();
delete.close();
stmt.close();
con.close();

} catch (Exception e) {
System.out.println(e);
}
}

public static void displayStudents(Connection con) {

try {
Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM students");

System.out.println("----------------------------------------");

while (rs.next()) {
System.out.println("Roll No : " + rs.getInt("roll_no"));
System.out.println("Name : " + rs.getString("name"));
System.out.println("Course : " + rs.getString("course"));
System.out.println("Marks : " + rs.getDouble("marks"));
System.out.println("----------------------------------------");
}

rs.close();
stmt.close();

} catch (Exception e) {
System.out.println(e);
}
}
}
