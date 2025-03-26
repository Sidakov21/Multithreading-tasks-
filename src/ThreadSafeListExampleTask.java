////Задача 2: Генерация последовательности чисел
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//public class ThreadSafeListExampleTask {
//    private static final List<Integer> numbers = new CopyOnWriteArrayList<>();
//
//    public static void main(String[] args) throws InterruptedException {
//        Runnable task = () -> {
//            for (int i = 1; i <= 100; i++) {
//                numbers.add(i);
//            }
//        };
//
//        Thread[] threads = new Thread[10];
//        for (int i = 0; i < threads.length; i++) {
//            threads[i] = new Thread(task);
//            threads[i].start();
//        }
//
//        // Ждём завершения всех потоков
//        for (Thread thread : threads) {
//            thread.join();
//        }
//
//        System.out.println("Общий размер списка: " + numbers.size()); // Ожидается 1000
//    }
//}