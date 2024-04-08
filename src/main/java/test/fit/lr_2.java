import java.util.Scanner;
import java.util.Random;

public class lr_2 {

    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ширину матриці (не більше " + MAX_SIZE + "):");
        int width = Math.min(scanner.nextInt(), MAX_SIZE);
        System.out.println("Введіть висоту матриці (не більше " + MAX_SIZE + "):");
        int height = Math.min(scanner.nextInt(), MAX_SIZE);

        int[][] matrix = createMatrix(width, height, scanner);
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);

        scanner.close();
    }

    private static int[][] createMatrix(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];
        System.out.println("Виберіть спосіб заповнення матриці: 1 - ручне введення, 2 - випадкові числа");
        int choice = scanner.nextInt();

        if (choice == 1) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.println("Введіть елемент [" + i + "][" + j + "]:");
                    matrix[i][j] = scanner.nextInt();
                }
            }
        } else if (choice == 2) {
            Random random = new Random();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }
}
