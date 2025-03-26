//Задача 12: Таймер с многопоточностью

import java.util.concurrent.atomic.AtomicBoolean;

public class ControlledTimer {
    private static final AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) {
        // Поток таймера
        Thread timerThread = new Thread(() -> {
            int seconds = 0;
            while (running.get()) {
                try {
                    Thread.sleep(1000);
                    seconds++;
                    System.out.println("Прошло " + seconds + " секунд");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Таймер прерван");
                    return;
                }
            }
            System.out.println("Таймер остановлен");
        });

        // Поток для остановки таймера
        Thread stopperThread = new Thread(() -> {
            try {
                Thread.sleep(10000);
                running.set(false);
                System.out.println("Отправлен сигнал остановки");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Запуск таймера");
        timerThread.start();
        stopperThread.start();

        try {
            timerThread.join();
            stopperThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Программа завершена");
    }
}
