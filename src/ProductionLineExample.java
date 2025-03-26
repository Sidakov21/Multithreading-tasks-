////Задача 8: Симуляция производственной линии
//
//import java.util.concurrent.*;
//
//public class ProductionLineExample {
//
//    public static void main(String[] args) {
//        // Создаем очередь с ограниченной емкостью
//        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
//
//        // Поток-производитель
//        Thread producer = new Thread(() -> {
//            try {
//                for (int i = 1; i <= 10; i++) {
//                    String product = "Продукт-" + i;
//                    queue.put(product); // Блокируется, если очередь полна
//                    System.out.println("Произведен: " + product);
//                    Thread.sleep(200); // Имитация времени производства
//                }
//                // Сигнал о завершении производства
//                queue.put("СТОП");
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//
//        // Поток-потребитель
//        Thread consumer = new Thread(() -> {
//            try {
//                while (true) {
//                    String product = queue.take(); // Блокируется, если очередь пуста
//                    if (product.equals("СТОП")) {
//                        break;
//                    }
//                    System.out.println("Обработан: " + product);
//                    Thread.sleep(500); // Имитация времени обработки
//                }
//                System.out.println("Все продукты обработаны");
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//
//        // Запускаем потоки
//        producer.start();
//        consumer.start();
//
//        // Ожидаем завершения
//        try {
//            producer.join();
//            consumer.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
