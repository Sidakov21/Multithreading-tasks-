////Задача 4: Симуляция работы банка
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//public class BankSyncExample {
//
//    private static class Account {
//        private int balance;
//
//        public Account(int initialBalance) {
//            this.balance = initialBalance;
//        }
//
//        public synchronized void deposit(int amount) {
//            balance += amount;
//        }
//
//        public synchronized void withdraw(int amount) {
//            balance -= amount;
//        }
//
//        public synchronized int getBalance() {
//            return balance;
//        }
//    }
//
//
//    private static class Bank {
//        private final Map<Integer, Account> accounts = new HashMap<>();
//        private final Random random = new Random();
//
//        public Bank(int accountCount, int initialBalance) {
//            for (int i = 0; i < accountCount; i++) {
//                accounts.put(i, new Account(initialBalance));
//            }
//        }
//
//        public synchronized void transfer(int from, int to, int amount) {
//            Account fromAccount = accounts.get(from);
//            Account toAccount = accounts.get(to);
//
//            if (fromAccount.getBalance() < amount) {
//                return; // Недостаточно средств
//            }
//
//            fromAccount.withdraw(amount);
//            toAccount.deposit(amount);
//        }
//
//        public int getTotalBalance() {
//            int total = 0;
//            for (Account account : accounts.values()) {
//                total += account.getBalance();
//            }
//            return total;
//        }
//
//        public void randomTransfer() {
//            int from = random.nextInt(accounts.size());
//            int to = random.nextInt(accounts.size());
//            int amount = random.nextInt(100);
//            transfer(from, to, amount);
//        }
//    }
//
//
//
//
//
//
//    public static void main(String[] args) throws InterruptedException {
//        final int ACCOUNTS = 10;
//        final int INITIAL_BALANCE = 1000;
//        final int THREADS = 20;
//        final int OPERATIONS = 1000;
//
//        Bank bank = new Bank(ACCOUNTS, INITIAL_BALANCE);
//
//        Runnable task = () -> {
//            for (int i = 0; i < OPERATIONS; i++) {
//                bank.randomTransfer();
//            }
//        };
//
//        Thread[] threads = new Thread[THREADS];
//        for (int i = 0; i < THREADS; i++) {
//            threads[i] = new Thread(task);
//            threads[i].start();
//        }
//
//        for (Thread thread : threads) {
//            thread.join();
//        }
//
//        System.out.println("Общий баланс: " + bank.getTotalBalance());
//        System.out.println("Ожидаемый баланс: " + ACCOUNTS * INITIAL_BALANCE);
//    }
//}
