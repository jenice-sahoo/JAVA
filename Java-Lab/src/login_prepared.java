package default_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login_prepared {

public static void main(String[] args) {

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Jen@1234";

Scanner sc = new Scanner(System.in);

System.out.print("Enter username: ");
String user = sc.nextLine();

System.out.print("Enter password: ");
String pass = sc.nextLine();

try {
Connection con = DriverManager.getConnection(url, username, password);

String query = "SELECT * FROM login_users WHERE username = ? AND password = ?";

PreparedStatement pstmt = con.prepareStatement(query);

pstmt.setString(1, user);
pstmt.setString(2, pass);

ResultSet rs = pstmt.executeQuery();

if (rs.next()) {
System.out.println("Login successful.");
System.out.println("Welcome " + user);
} else {
System.out.println("Invalid username or password.");
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
