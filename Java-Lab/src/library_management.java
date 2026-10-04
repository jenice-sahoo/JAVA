package default_;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class library_management extends JFrame {

JTextField bookId;
JTextField bookName;
JTextField author;
JTextField quantity;

DefaultTableModel model;
JTable table;

String url = "jdbc:mysql://localhost:3306/java_sample_db";
String username = "root";
String password = "Jen@1234";

public library_management() {

setTitle("Library Management System");
setSize(800, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());

JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

bookId = new JTextField();
bookName = new JTextField();
author = new JTextField();
quantity = new JTextField();

panel.add(new JLabel("Book ID"));
panel.add(bookId);

panel.add(new JLabel("Book Name"));
panel.add(bookName);

panel.add(new JLabel("Author"));
panel.add(author);

panel.add(new JLabel("Quantity"));
panel.add(quantity);

JButton addButton = new JButton("Add");
JButton updateButton = new JButton("Update");

panel.add(addButton);
panel.add(updateButton);

add(panel, BorderLayout.NORTH);

model = new DefaultTableModel();

model.addColumn("Book ID");
model.addColumn("Book Name");
model.addColumn("Author");
model.addColumn("Quantity");

table = new JTable(model);

add(new JScrollPane(table), BorderLayout.CENTER);

JPanel buttons = new JPanel();

JButton deleteButton = new JButton("Delete");
JButton clearButton = new JButton("Clear");

buttons.add(deleteButton);
buttons.add(clearButton);

add(buttons, BorderLayout.SOUTH);

addButton.addActionListener(e -> addBook());
updateButton.addActionListener(e -> updateBook());
deleteButton.addActionListener(e -> deleteBook());
clearButton.addActionListener(e -> clearFields());

loadBooks();

setVisible(true);
}

void addBook() {

try {

Connection con = DriverManager.getConnection(url, username, password);

PreparedStatement pstmt = con.prepareStatement(
"INSERT INTO library_books VALUES (?, ?, ?, ?)");

pstmt.setInt(1, Integer.parseInt(bookId.getText()));
pstmt.setString(2, bookName.getText());
pstmt.setString(3, author.getText());
pstmt.setInt(4, Integer.parseInt(quantity.getText()));

pstmt.executeUpdate();

JOptionPane.showMessageDialog(this, "Book added successfully.");

pstmt.close();
con.close();

loadBooks();

} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
}

void updateBook() {

try {

Connection con = DriverManager.getConnection(url, username, password);

PreparedStatement pstmt = con.prepareStatement(
"UPDATE library_books SET book_name=?, author=?, quantity=? WHERE book_id=?");

pstmt.setString(1, bookName.getText());
pstmt.setString(2, author.getText());
pstmt.setInt(3, Integer.parseInt(quantity.getText()));
pstmt.setInt(4, Integer.parseInt(bookId.getText()));

pstmt.executeUpdate();

JOptionPane.showMessageDialog(this, "Book updated successfully.");

pstmt.close();
con.close();

loadBooks();

} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
}

void deleteBook() {

try {

Connection con = DriverManager.getConnection(url, username, password);

PreparedStatement pstmt = con.prepareStatement(
"DELETE FROM library_books WHERE book_id=?");

pstmt.setInt(1, Integer.parseInt(bookId.getText()));

pstmt.executeUpdate();

JOptionPane.showMessageDialog(this, "Book deleted successfully.");

pstmt.close();
con.close();

loadBooks();

} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
}

void loadBooks() {

model.setRowCount(0);

try {

Connection con = DriverManager.getConnection(url, username, password);

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM library_books");

while (rs.next()) {

model.addRow(new Object[] {
rs.getInt("book_id"),
rs.getString("book_name"),
rs.getString("author"),
rs.getInt("quantity")
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
bookName.setText("");
author.setText("");
quantity.setText("");
}

public static void main(String[] args) {

new library_management();
}
}
