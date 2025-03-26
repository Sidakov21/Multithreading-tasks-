////Задача 3: Распределение задач с использованием пула потоков
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ThreadPoolExample {
//    public static void main(String[] args) {
//        // 1. Создаём пул из 4 потоков
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        // 2. Запускаем 20 задач
//        for (int i = 1; i <= 20; i++) {
//            final int taskNumber = i;  // final-переменная для лямбды
//            executor.submit(() -> {
//                System.out.println(
//                        "Задача " + taskNumber + " выполняется в потоке: " +
//                                Thread.currentThread().getName()
//                );
//            });
//        }
//
//        // 3. Завершаем работу пула (важно!)
//        executor.shutdown();
//    }
//
//}
