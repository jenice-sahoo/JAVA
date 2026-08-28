import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc extends JFrame implements ActionListener {

    JTextField num1, num2, result;
    JButton add, sub;

    Calc() {
        setTitle("Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2));

        num1 = new JTextField();
        num2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        add = new JButton("Addition");
        sub = new JButton("Subtraction");

        add(new JLabel("Number 1:"));
        add(num1);

        add(new JLabel("Number 2:"));
        add(num2);

        add(new JLabel("Result:"));
        add(result);

        add(add);
        add(sub);

        add.addActionListener(this);
        sub.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(num1.getText());
        int b = Integer.parseInt(num2.getText());

        if (e.getSource() == add)
            result.setText("" + (a + b));
        else
            result.setText("" + (a - b));
    }

    public static void main(String[] args) {
        new Calc();
    }
}