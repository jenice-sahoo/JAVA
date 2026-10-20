<%@ page import="java.sql.*" %>
<%
String url = "jdbc:mysql://localhost:3306/company";
String dbUser = "rithvin";
String dbPass = "1974";

String action = request.getParameter("action");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        url, dbUser, dbPass);

    if ("add".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO employee VALUES(?,?,?,?)");
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        ps.setString(2, request.getParameter("name"));
        ps.setString(3, request.getParameter("department"));
        ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));
        ps.executeUpdate();
        ps.close();
    } else if ("update".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE employee SET name=?, department=?, salary=? WHERE id=?");
        ps.setString(1, request.getParameter("name"));
        ps.setString(2, request.getParameter("department"));
        ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
        ps.setInt(4, Integer.parseInt(request.getParameter("id")));
        ps.executeUpdate();
        ps.close();
    } else if ("delete".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM employee WHERE id=?");
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        ps.executeUpdate();
        ps.close();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
    <h2>Employee Management System</h2>

    <h3>Add Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="add">
        ID: <input type="number" name="id" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Department: <input type="text" name="department" required><br><br>
        Salary: <input type="number" step="0.01" name="salary" required><br><br>
        <input type="submit" value="Add Employee">
    </form>

    <h3>Update Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="update">
        ID: <input type="number" name="id" required><br><br>
        New Name: <input type="text" name="name" required><br><br>
        Department: <input type="text" name="department" required><br><br>
        Salary: <input type="number" step="0.01" name="salary" required><br><br>
        <input type="submit" value="Update Employee">
    </form>

    <h3>Delete Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="delete">
        ID: <input type="number" name="id" required>
        <input type="submit" value="Delete Employee">
    </form>

    <h3>Employee Records</h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th><th>Name</th>
            <th>Department</th><th>Salary</th>
        </tr>
        <%
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employee");
        while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getDouble("salary") %></td>
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
