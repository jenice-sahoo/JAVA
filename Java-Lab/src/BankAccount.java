class BankAccount {
    int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit: Rs." + amount +
                           " | Balance: Rs." + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal: Rs." + amount +
                               " | Balance: Rs." + balance);
        } else {
            System.out.println("Withdrawal failed: Insufficient balance");
        }
    }
}

class DepositThread extends Thread {
    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.deposit(500);
        }
    }
}

class WithdrawalThread extends Thread {
    BankAccount account;

    WithdrawalThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withdraw(300);
        }
    }
}

public class BankTransaction {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        DepositThread deposit = new DepositThread(account);
        WithdrawalThread withdraw = new WithdrawalThread(account);

        deposit.start();
        withdraw.start();
    }
}