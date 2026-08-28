import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankBalance extends JFrame implements ActionListener {

    JTextField balance, amount, result;
    JButton deposit, withdraw;

    BankBalance() {
        setTitle("Bank Balance Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2));

        balance = new JTextField();
        amount = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");

        add(new JLabel("Initial Balance:"));
        add(balance);

        add(new JLabel("Transaction Amount:"));
        add(amount);

        add(new JLabel("Updated Balance:"));
        add(result);

        add(deposit);
        add(withdraw);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double b = Double.parseDouble(balance.getText());
        double a = Double.parseDouble(amount.getText());

        if (e.getSource() == deposit)
            result.setText("" + (b + a));
        else
            result.setText("" + (b - a));
    }

    public static void main(String[] args) {
        new BankBalance();
    }
}