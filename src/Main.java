//Задача 1. Счетчик с разных потоков
//class Counter {
//    private int count = 0;
//
//    // Метод для увеличения счётчика
//    public synchronized void increment() {
//        count++;
//    }
//
//    // Метод для получения текущего значения счётчика
//    public int getCount() {
//        return count;
//    }
//}
//
//class CounterThread extends Thread {
//    private Counter counter;
//
//    public CounterThread(Counter counter) {
//        this.counter = counter;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            counter.increment();
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Counter counter = new Counter();
//        Thread[] threads = new Thread[5];
//
//        // Создаем и запускаем 5 потоков
//        for (int i = 0; i < 5; i++) {
//            threads[i] = new CounterThread(counter);
//            threads[i].start();
//        }
//
//        // Ждем завершения всех потоков
//        for (int i = 0; i < 5; i++) {
//            try {
//                threads[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Выводим итоговое значение счётчика
//        System.out.println("Final count: " + counter.getCount());
//    }
//}
