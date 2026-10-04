package default_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class resultset_record {

public static void main(String[] args) {

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Jen@1234";

try {

Connection con = DriverManager.getConnection(url, username, password);

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM products");

System.out.println("Database Records");
System.out.println("----------------------------------------");

while (rs.next()) {

System.out.println("Product ID : " + rs.getInt("product_id"));
System.out.println("Product Name : " + rs.getString("product_name"));
System.out.println("Product quantity : " + rs.getString("quantity"));
System.out.println("Product Price : " + rs.getDouble("price"));

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
