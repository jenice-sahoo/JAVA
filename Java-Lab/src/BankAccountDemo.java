class BankAccount {
    final int accountNumber;
    String name;
    double balance;

    BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    final void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(101, "Jenice", 50000);

        account.displayAccount();

        // account.accountNumber = 202;
        // This will give an error because accountNumber is final.
    }
}