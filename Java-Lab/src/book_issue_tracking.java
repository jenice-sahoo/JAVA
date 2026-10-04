package default_;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class book_issue_tracking extends JFrame {

JTextField bookId;
JTextField studentName;
JTextField issueDate;
JTextField returnDate;

DefaultTableModel model;
JTable table;

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Jen@1234";

public book_issue_tracking() {

setTitle("Book Issue Tracking System");
setSize(850, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());

JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

bookId = new JTextField();
studentName = new JTextField();
issueDate = new JTextField();
returnDate = new JTextField();

panel.add(new JLabel("Book ID"));
panel.add(bookId);

panel.add(new JLabel("Student Name"));
panel.add(studentName);

panel.add(new JLabel("Issue Date"));
panel.add(issueDate);

panel.add(new JLabel("Return Date"));
panel.add(returnDate);

JButton addButton = new JButton("Issue Book");
JButton updateButton = new JButton("Update");

panel.add(addButton);
panel.add(updateButton);

add(panel, BorderLayout.NORTH);

model = new DefaultTableModel();

model.addColumn("Book ID");
model.addColumn("Student Name");
model.addColumn("Issue Date");
model.addColumn("Return Date");

table = new JTable(model);

add(new JScrollPane(table), BorderLayout.CENTER);

JPanel buttons = new JPanel();

JButton deleteButton = new JButton("Delete");
JButton clearButton = new JButton("Clear");

buttons.add(deleteButton);
buttons.add(clearButton);

add(buttons, BorderLayout.SOUTH);

addButton.addActionListener(e -> issueBook());
updateButton.addActionListener(e -> updateRecord());
deleteButton.addActionListener(e -> deleteRecord());
clearButton.addActionListener(e -> clearFields());

loadRecords();

setVisible(true);
}

void issueBook() {

try {

Connection con = DriverManager.getConnection(url, username, password);

PreparedStatement pstmt = con.prepareStatement(
"INSERT INTO book_issue_tracking VALUES (?, ?, ?, ?)");

pstmt.setInt(1, Integer.parseInt(bookId.getText()));
pstmt.setString(2, studentName.getText());
pstmt.setDate(3, Date.valueOf(issueDate.getText()));
pstmt.setDate(4, Date.valueOf(returnDate.getText()));

pstmt.executeUpdate();

JOptionPane.showMessageDialog(this, "Book issued successfully.");

pstmt.close();
con.close();

loadRecords();

} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
}

void updateRecord() {

try {

Connection con = DriverManager.getConnection(url, username, password);

PreparedStatement pstmt = con.prepareStatement(
"UPDATE book_issue_tracking SET student_name=?, issue_date=?, return_date=? WHERE book_id=?");

pstmt.setString(1, studentName.getText());
pstmt.setDate(2, Date.valueOf(issueDate.getText()));
pstmt.setDate(3, Date.valueOf(returnDate.getText()));
pstmt.setInt(4, Integer.parseInt(bookId.getText()));

pstmt.executeUpdate();

JOptionPane.showMessageDialog(this, "Book issue record updated successfully.");

pstmt.close();
con.close();

loadRecords();

} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
}

void deleteRecord() {

try {

Connection con = DriverManager.getConnection(url, username, password);

PreparedStatement pstmt = con.prepareStatement(
"DELETE FROM book_issue_tracking WHERE book_id=?");

pstmt.setInt(1, Integer.parseInt(bookId.getText()));

pstmt.executeUpdate();

JOptionPane.showMessageDialog(this, "Book issue record deleted successfully.");

pstmt.close();
con.close();

loadRecords();

} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
}

void loadRecords() {

model.setRowCount(0);

try {

Connection con = DriverManager.getConnection(url, username, password);

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery(
"SELECT * FROM book_issue_tracking");

while (rs.next()) {

model.addRow(new Object[] {
rs.getInt("book_id"),
rs.getString("student_name"),
rs.getDate("issue_date"),
rs.getDate("return_date")
});
}

rs.close();
stmt.close();
con.close();

} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
}

void clearFields() {

bookId.setText("");
studentName.setText("");
issueDate.setText("");
returnDate.setText("");
}

public static void main(String[] args) {

new book_issue_tracking();
}
}
