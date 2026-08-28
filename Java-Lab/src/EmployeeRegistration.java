import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeRegistration extends JFrame {

    JTextField idField, nameField, deptField, salaryField;

    EmployeeRegistration() {

        setTitle("Employee Registration Form");
        setSize(450, 300);
        setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("Employee ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel deptLabel = new JLabel("Department:");
        JLabel salaryLabel = new JLabel("Salary:");

        idField = new JTextField();
        nameField = new JTextField();
        deptField = new JTextField();
        salaryField = new JTextField();

        JButton submitButton = new JButton("Submit");

        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(deptLabel);
        add(deptField);

        add(salaryLabel);
        add(salaryField);

        add(new JLabel(""));
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = idField.getText();
                String name = nameField.getText();
                String department = deptField.getText();
                String salary = salaryField.getText();

                JOptionPane.showMessageDialog(
                    EmployeeRegistration.this,
                    "Employee Details\n\n" +
                    "Employee ID: " + id + "\n" +
                    "Name: " + name + "\n" +
                    "Department: " + department + "\n" +
                    "Salary: " + salary
                );
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeRegistration();
    }
}