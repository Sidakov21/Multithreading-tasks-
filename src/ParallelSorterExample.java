//Задача 9: Многопоточная сортировка

import java.util.Arrays;
import java.util.concurrent.*;

public class ParallelSorterExample {
    private static final int THREADS = 4; // Количество потоков для сортировки

    // Метод для параллельной сортировки
    public static int[] parallelSort(int[] array) {
        // Разделяем массив на части
        int[][] parts = splitArray(array, THREADS);

        // Создаем пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        Future<int[]>[] futures = new Future[THREADS];

        // Запускаем сортировку каждой части в отдельном потоке
        for (int i = 0; i < THREADS; i++) {
            final int[] part = parts[i];
            futures[i] = executor.submit(() -> {
                Arrays.sort(part);
                return part;
            });
        }

        // Получаем отсортированные части
        int[][] sortedParts = new int[THREADS][];
        for (int i = 0; i < THREADS; i++) {
            try {
                sortedParts[i] = futures[i].get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Завершаем работу пула потоков
        executor.shutdown();

        // Объединяем отсортированные части
        return mergeSortedParts(sortedParts);
    }



    // Разделение массива на части
    private static int[][] splitArray(int[] array, int partsCount) {
        int[][] parts = new int[partsCount][];
        int partSize = array.length / partsCount;

        for (int i = 0; i < partsCount; i++) {
            int start = i * partSize;
            int end = (i == partsCount - 1) ? array.length : (i + 1) * partSize;
            parts[i] = Arrays.copyOfRange(array, start, end);
        }

        return parts;
    }




    // Слияние отсортированных частей
    private static int[] mergeSortedParts(int[][] parts) {
        // Если только одна часть - возвращаем её
        if (parts.length == 1) {
            return parts[0];
        }

        // Объединяем попарно
        int[][] newParts = new int[(parts.length + 1) / 2][];
        for (int i = 0; i < newParts.length; i++) {
            if (2 * i + 1 < parts.length) {
                newParts[i] = mergeTwoArrays(parts[2 * i], parts[2 * i + 1]);
            } else {
                newParts[i] = parts[2 * i];
            }
        }

        // Рекурсивно продолжаем объединение
        return mergeSortedParts(newParts);
    }




    // Слияние двух отсортированных массивов
    private static int[] mergeTwoArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }




    // Создание массива случайных чисел
    private static int[] createRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1_000_000);
        }
        return array;
    }



    // Проверка правильности сортировки
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        // Создаем большой массив для сортировки
        int[] array = createRandomArray(100_000);

        System.out.println("Начало параллельной сортировки...");
        long startTime = System.currentTimeMillis();

        // Сортируем массив в нескольких потоках
        int[] sortedArray = parallelSort(array);

        long endTime = System.currentTimeMillis();
        System.out.println("Сортировка завершена за " + (endTime - startTime) + " мс");

        // Проверяем результат
        System.out.println("Проверка сортировки: " + isSorted(sortedArray));
    }
}
