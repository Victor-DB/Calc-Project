package parallel.task1;

public class SynchAccountMain {

    private static class WithdrawThread extends Thread {
        private final Account account;

        private WithdrawThread(Account account) { this.account = account; }

        @Override
        public void run() {
            for (int i = 0; i < 15000; i++) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositThread extends Thread {
        private final Account account;

        private DepositThread(Account account) { this.account = account; }

        @Override
        public void run() {
            for (int i = 0; i < 15000; i++) {
                account.deposit(1);
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100000);
        Thread withdrawThreadThread = new WithdrawThread(account);
        Thread depositThreadThread = new DepositThread(account);
        System.out.println("Start balance: " + account.getBalance());

        withdrawThreadThread.start();
        depositThreadThread.start();

        withdrawThreadThread.join();
        depositThreadThread.join();

        System.out.println("All balance is: " + account.getBalance());
        
    }

}
