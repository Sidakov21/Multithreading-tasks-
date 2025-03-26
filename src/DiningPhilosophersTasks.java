////Задача 10: Обед философов (*)
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class DiningPhilosophersTasks {
//
//    static class Philosopher implements Runnable {
//        private final int id;
//        private final Lock leftFork;
//        private final Lock rightFork;
//
//        public Philosopher(int id, Lock leftFork, Lock rightFork) {
//            this.id = id;
//            this.leftFork = leftFork;
//            this.rightFork = rightFork;
//        }
//
//        private void think() throws InterruptedException {
//            System.out.println("Философ " + id + " размышляет");
//            Thread.sleep((long) (Math.random() * 1000));
//        }
//
//        private void eat() throws InterruptedException {
//            System.out.println("Философ " + id + " ест");
//            Thread.sleep((long) (Math.random() * 1000));
//        }
//
//        @Override
//        public void run() {
//            try {
//                int c = 0;
//                while (c != 1) {
//                    think();
//
//                    // Берем вилки
//                    if (id % 2 == 0) {
//                        leftFork.lock();
//                        rightFork.lock();
//                    } else {
//                        rightFork.lock();
//                        leftFork.lock();
//                    }
//
//                    eat();
//
//                    // Кладем вилки
//                    leftFork.unlock();
//                    rightFork.unlock();
//
//                    //Увеличиваем счетчик
//                    c++;
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        final int PHILOSOPHERS_COUNT = 5;
//        Philosopher[] philosophers = new Philosopher[PHILOSOPHERS_COUNT];
//        Lock[] forks = new Lock[PHILOSOPHERS_COUNT];
//
//        // Создаем вилки
//        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
//            forks[i] = new ReentrantLock();
//        }
//
//        // Создаем философов
//        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
//            Lock leftFork = forks[i];
//            Lock rightFork = forks[(i + 1) % PHILOSOPHERS_COUNT];
//
//            philosophers[i] = new Philosopher(i, leftFork, rightFork);
//
//            // Для избежания deadlock меняем порядок взятия вилок у одного философа
//            if (i == PHILOSOPHERS_COUNT - 1) {
//                // Последний философ сначала берет правую вилку
//                philosophers[i] = new Philosopher(i, rightFork, leftFork);
//            }
//
//            new Thread(philosophers[i]).start();
//        }
//    }
//}
