package default_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class hosptial_login {

public static void main(String[] args) {

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Jen@1234";

Scanner sc = new Scanner(System.in);

System.out.print("Enter Login ID: ");
String loginId = sc.nextLine();

System.out.print("Enter Password: ");
String loginPassword = sc.nextLine();

try {
Connection con = DriverManager.getConnection(url, username, password);

String query = "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?";

PreparedStatement pstmt = con.prepareStatement(query);

pstmt.setString(1, loginId);
pstmt.setString(2, loginPassword);

ResultSet rs = pstmt.executeQuery();

if (rs.next()) {
String role = rs.getString("role");

System.out.println("Authentication Successful.");
System.out.println("Access Granted.");
System.out.println("Logged in as: " + role);
} else {
System.out.println("Authentication Failed.");
System.out.println("Access Denied.");
}

rs.close();
pstmt.close();
con.close();
sc.close();

} catch (Exception e) {
System.out.println(e);
}
}
}
