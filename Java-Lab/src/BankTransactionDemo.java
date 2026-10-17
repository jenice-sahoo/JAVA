class BankAccount {
    private int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: Rs." + amount
                + " | Balance: Rs." + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount
                    + " | Balance: Rs." + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class DepositTask implements Runnable {
    private BankAccount account;

    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.deposit(500);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WithdrawTask implements Runnable {
    private BankAccount account;

    WithdrawTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withdraw(300);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BankTransactionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread depositThread =
                new Thread(new DepositTask(account));
        Thread withdrawThread =
                new Thread(new WithdrawTask(account));

        depositThread.start();
        withdrawThread.start();
    }
}
