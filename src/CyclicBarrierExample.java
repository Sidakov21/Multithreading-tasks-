////Задача 5: Барьер синхронизации
//
//import java.util.concurrent.BrokenBarrierException;
//import java.util.concurrent.CyclicBarrier;
//
//public class CyclicBarrierExample {
//
//    public static void main(String[] args) {
//        // Создаем барьер на 5 потоков + действие при достижении барьера
//        final int THREAD_COUNT = 5;
//        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
//            System.out.println("\nВсе потоки достигли барьера! Начинаем новую фазу...\n");
//        });
//
//        // Создаем и запускаем потоки
//        for (int i = 0; i < THREAD_COUNT; i++) {
//            final int threadNumber = i;
//            new Thread(() -> {
//                try {
//                    // Фаза 1
//                    System.out.println("Поток " + threadNumber + " выполняет первую часть работы");
//                    Thread.sleep((long) (Math.random() * 2000)); // Имитация работы
//                    System.out.println("Поток " + threadNumber + " завершил первую часть и ждет остальных");
//                    barrier.await(); // Ожидание других потоков
//
//                    // Фаза 2
//                    System.out.println("Поток " + threadNumber + " выполняет вторую часть работы");
//                    Thread.sleep((long) (Math.random() * 2000)); // Имитация работы
//                    System.out.println("Поток " + threadNumber + " завершил вторую часть и ждет остальных");
//                    barrier.await(); // Ожидание других потоков
//
//                    // Фаза 3
//                    System.out.println("Поток " + threadNumber + " завершает работу");
//                } catch (InterruptedException | BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//    }
//}
