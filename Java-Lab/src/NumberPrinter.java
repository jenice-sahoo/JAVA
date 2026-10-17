public class BankMulti {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10);

        Thread depositThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                account.deposit(10000);
            }
        });

        Thread withdrawalThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                account.withdraw(5000);
            }
        });


        depositThread.start();
        withdrawalThread.start();
    }


    static class BankAccount {

        private int balance;

        BankAccount(int balance) {
            this.balance = balance;
        }


        synchronized void deposit(int amount) {

            balance = balance + amount;

            System.out.println(
                "Deposit: Rs. " + amount +
                " | Balance: Rs. " + balance
            );

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }


        synchronized void withdraw(int amount) {

            if (balance >= amount) {

                balance = balance - amount;

                System.out.println(
                    "Withdrawal: Rs. " + amount +
                    " | Balance: Rs. " + balance
                );

            } else {
                System.out.println("Withdrawal failed: Insufficient balance");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}