////Задача 7: Обработка результатов задач
//
//import java.util.concurrent.*;
//import java.math.BigInteger;
//
//public class FutureExample {
//    // Класс для вычисления факториала
//    private static class FactorialCalculator implements Callable<BigInteger> {
//        private final int number;
//
//        public FactorialCalculator(int number) {
//            this.number = number;
//        }
//
//        @Override
//        public BigInteger call() throws Exception {
//            BigInteger result = BigInteger.ONE;
//
//            // Вычисляем факториал
//            for (int i = 2; i <= number; i++) {
//                result = result.multiply(BigInteger.valueOf(i));
//                // Имитация долгого вычисления
//                Thread.sleep(100);
//            }
//
//            return result;
//        }
//    }
//
//    public static void main(String[] args) {
//        // Создаем пул потоков
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//
//        // Массив для хранения Future объектов
//        Future<BigInteger>[] futures = new Future[10];
//
//        // Запускаем задачи
//        for (int i = 0; i < 10; i++) {
//            int number = 10 + i; // Вычисляем факториал для чисел от 10 до 19
//            Callable<BigInteger> task = new FactorialCalculator(number);
//            futures[i] = executor.submit(task);
//            System.out.println("Запущена задача для вычисления " + number + "!");
//        }
//
//        // Получаем результаты
//        for (int i = 0; i < 10; i++) {
//            try {
//                // get() блокирует поток, пока результат не будет готов
//                BigInteger result = futures[i].get();
//                System.out.println((10 + i) + "! = " + result);
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Завершаем работу пула
//        executor.shutdown();
//
//        try {
//            // Ждем завершения всех задач (не более 1 дня)
//            if (!executor.awaitTermination(1, TimeUnit.DAYS)) {
//                executor.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            executor.shutdownNow();
//        }
//    }
//}
