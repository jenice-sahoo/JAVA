import java.sql.*;

public class StudentRecords {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "rithvin";
        String password = "1974";

        String query = "SELECT * FROM students";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records");
            System.out.println("-----------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String course = rs.getString("course");
                int marks = rs.getInt("marks");

                System.out.println(
                    id + " | " + name + " | " + course + " | " + marks
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
