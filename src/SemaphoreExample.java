//// Задача 6: Ограниченный доступ к ресурсу
//
//import java.util.concurrent.Semaphore;
//
//public class SemaphoreExample {
//
//    public static void main(String[] args) {
//        // Создаем семафор с 2 разрешениями
//        final int MAX_AVAILABLE = 2;
//        Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true); // true - честный режим (FIFO)
//
//        // Количество потоков, пытающихся получить доступ
//        final int THREAD_COUNT = 6;
//
//        // Создаем и запускаем потоки
//        for (int i = 0; i < THREAD_COUNT; i++) {
//            final int threadNumber = i;
//            new Thread(() -> {
//                try {
//                    System.out.println("Поток " + threadNumber + " пытается получить доступ");
//
//                    // Запрашиваем разрешение у семафора
//                    semaphore.acquire();
//
//                    try {
//                        System.out.println("Поток " + threadNumber + " получил доступ. Работает с ресурсом...");
//                        // Имитация работы с ресурсом
//                        Thread.sleep(2000 + (long)(Math.random() * 3000));
//                        System.out.println("Поток " + threadNumber + " завершил работу с ресурсом");
//                    } finally {
//                        // Освобождаем разрешение
//                        semaphore.release();
//                        System.out.println("Поток " + threadNumber + " освободил доступ");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//    }
//}
