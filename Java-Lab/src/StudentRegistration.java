import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {

    JTextField nameField, rollField, courseField;

    StudentRegistration() {

        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        JLabel rollLabel = new JLabel("Roll No:");
        JLabel courseLabel = new JLabel("Course:");

        nameField = new JTextField();
        rollField = new JTextField();
        courseField = new JTextField();

        JButton submitButton = new JButton("Register");

        add(nameLabel);
        add(nameField);

        add(rollLabel);
        add(rollField);

        add(courseLabel);
        add(courseField);

        add(new JLabel(""));
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String roll = rollField.getText();
                String course = courseField.getText();

                JOptionPane.showMessageDialog(
                    StudentRegistration.this,
                    "Student Registered Successfully!\n" +
                    "Name: " + name + "\n" +
                    "Roll No: " + roll + "\n" +
                    "Course: " + course
                );
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}