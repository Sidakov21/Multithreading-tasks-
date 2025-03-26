////Задача 11: Расчёт матрицы в параллельных потоках
//
//import java.util.concurrent.*;
//
//public class MatrixMultiplier {
//    private static final int THREADS = Runtime.getRuntime().availableProcessors();
//
//    public static int[][] multiply(int[][] a, int[][] b) throws InterruptedException, ExecutionException {
//        int rowsA = a.length;
//        int colsA = a[0].length;
//        int colsB = b[0].length;
//
//        // Проверка совместимости матриц
//        if (colsA != b.length) {
//            throw new IllegalArgumentException("Несовместимые размеры матриц");
//        }
//
//        int[][] result = new int[rowsA][colsB];
//        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
//        Future<?>[] futures = new Future[rowsA];
//
//        // Создаем задачи для каждой строки
//        for (int i = 0; i < rowsA; i++) {
//            final int row = i;
//            futures[i] = executor.submit(() -> {
//                for (int j = 0; j < colsB; j++) {
//                    for (int k = 0; k < colsA; k++) {
//                        result[row][j] += a[row][k] * b[k][j];
//                    }
//                }
//            });
//        }
//
//        // Ожидаем завершения всех задач
//        for (Future<?> future : futures) {
//            future.get();
//        }
//
//        executor.shutdown();
//        return result;
//    }
//
//    private static void printMatrix(int[][] matrix) {
//        for (int[] row : matrix) {
//            for (int val : row) {
//                System.out.print(val + " ");
//            }
//            System.out.println();
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//        // Пример матриц
//        int[][] matrixA = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        int[][] matrixB = {
//                {9, 8, 7},
//                {6, 5, 4},
//                {3, 2, 1}
//        };
//
//        try {
//            int[][] result = multiply(matrixA, matrixB);
//            printMatrix(result);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//}