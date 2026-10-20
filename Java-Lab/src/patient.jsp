<%@ page import="java.sql.*" %>
<%
String url = "jdbc:mysql://localhost:3306/hospital";
String dbUser = "rithvin";
String dbPass = "1974";

String action = request.getParameter("action");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        url, dbUser, dbPass);

    if ("add".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO patient VALUES(?,?,?,?,?)");
        ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
        ps.setString(2, request.getParameter("name"));
        ps.setInt(3, Integer.parseInt(request.getParameter("age")));
        ps.setString(4, request.getParameter("disease"));
        ps.setString(5, request.getParameter("status"));
        ps.executeUpdate();
        ps.close();

    } else if ("update".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE patient SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?");
        ps.setString(1, request.getParameter("name"));
        ps.setInt(2, Integer.parseInt(request.getParameter("age")));
        ps.setString(3, request.getParameter("disease"));
        ps.setString(4, request.getParameter("status"));
        ps.setInt(5, Integer.parseInt(request.getParameter("patient_id")));
        ps.executeUpdate();
        ps.close();

    } else if ("delete".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM patient WHERE patient_id=?");
        ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
        ps.executeUpdate();
        ps.close();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Patient Management</title>
</head>
<body>
    <h2>Patient Record Management System</h2>

    <h3>Add Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="add">
        Patient ID: <input type="number" name="patient_id" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" required><br><br>
        Disease: <input type="text" name="disease" required><br><br>
        Treatment Status: <input type="text" name="status" required><br><br>
        <input type="submit" value="Add Patient">
    </form>

    <h3>Update Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="update">
        Patient ID: <input type="number" name="patient_id" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" required><br><br>
        Disease: <input type="text" name="disease" required><br><br>
        Treatment Status: <input type="text" name="status" required><br><br>
        <input type="submit" value="Update Patient">
    </form>

    <h3>Delete Patient</h3>
    <form method="post">
        Patient ID: <input type="number" name="patient_id" required>
        <input type="hidden" name="action" value="delete">
        <input type="submit" value="Delete Patient">
    </form>

    <h3>Patient Records</h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th><th>Name</th><th>Age</th>
            <th>Disease</th><th>Treatment Status</th>
        </tr>
        <%
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patient");
        while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
        </tr>
        <% }
        rs.close();
        st.close();
        con.close();
        %>
    </table>
</body>
</html>

<%
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>
