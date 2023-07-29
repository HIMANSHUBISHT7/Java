import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Scientific Calculator!");

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Square Root (√)");
            System.out.println("6. Exponentiation (^)");
            System.out.println("7. Matrix Addition");
            System.out.println("8. Matrix Subtraction");
            System.out.println("9. Matrix Multiplication");
            System.out.println("10. Matrix Transposition");
            System.out.println("11. Natural Logarithm (ln)");
            System.out.println("12. Base 10 Logarithm (log10)");
            System.out.println("13. Base 2 Logarithm (log2)");
            System.out.println("14. Exit \n");
            System.out.print("select: ");
            int choice = scanner.nextInt();

            if (choice == 14) {
                break;
            }
            System.out.print("Enter the number for log operations otherwise enter 0: ");
            double number = scanner.nextDouble();

            double result = 0.0;

            switch (choice) {
                case 1:
                    result = addition(scanner);
                    break;
                case 2:
                    result = subtraction(scanner);
                    break;
                case 3:
                    result = multiplication(scanner);
                    break;
                case 4:
                    result = division(scanner);
                    break;
                case 5:
                    result = squareRoot(scanner);
                    break;
                case 6:
                    result = exponentiation(scanner);
                    break;
                case 7:
                    performMatrixAddition(scanner);
                    break;
                case 8:
                    performMatrixSubtraction(scanner);
                    break;
                case 9:
                    performMatrixMultiplication(scanner);
                    break;
                case 10:
                    performMatrixTransposition(scanner);
                    break;
                case 11:
                    result = calculateNaturalLogarithm(number);
                    break;
                case 12:
                    result = calculateBase10Logarithm(number);
                    break;
                case 13:
                    result = calculateBase2Logarithm(number);
                    break;    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
            System.out.println("Result:" + result);
            System.out.println();            
        }

        System.out.println("Thank you for using the Scientific Calculator!");
        scanner.close();
    }

    private static double addition(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 + num2;
    }

    private static double subtraction(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 - num2;
    }

    private static double multiplication(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 * num2;
    }

    private static double division(Scanner scanner) {
        System.out.print("Enter the numerator: ");
        double numerator = scanner.nextDouble();
        System.out.print("Enter the denominator: ");
        double denominator = scanner.nextDouble();
        if (denominator != 0) {
            return numerator / denominator;
        } else {
            System.out.println("Division by zero is not allowed.");
            return 0.0;
        }
    }

    private static double squareRoot(Scanner scanner) {
        System.out.print("Enter the number: ");
        double num = scanner.nextDouble();
        return Math.sqrt(num);
    }

    private static double exponentiation(Scanner scanner) {
        System.out.print("Enter the base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter the exponent: ");
        double exponent = scanner.nextDouble();
        return Math.pow(base, exponent);
    }

    private static void performMatrixAddition(Scanner scanner) {
        double[][] matrix1 = getMatrixFromUser(scanner, "Enter the first matrix:");
        double[][] matrix2 = getMatrixFromUser(scanner, "Enter the second matrix:");

        if (areMatricesCompatibleForOperation(matrix1, matrix2)) {
            double[][] result = new double[matrix1.length][matrix1[0].length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

            displayMatrix("Result:", result);
        } else {
            System.out.println("Matrices are not compatible for addition.");
        }
    }

    private static void performMatrixSubtraction(Scanner scanner) {
        double[][] matrix1 = getMatrixFromUser(scanner, "Enter the first matrix:");
        double[][] matrix2 = getMatrixFromUser(scanner, "Enter the second matrix:");

        if (areMatricesCompatibleForOperation(matrix1, matrix2)) {
            double[][] result = new double[matrix1.length][matrix1[0].length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }

            displayMatrix("Result:", result);
        } else {
            System.out.println("Matrices are not compatible for subtraction.");
        }
    }

    private static void performMatrixMultiplication(Scanner scanner) {
        double[][] matrix1 = getMatrixFromUser(scanner, "Enter the first matrix:");
        double[][] matrix2 = getMatrixFromUser(scanner, "Enter the second matrix:");

        if (areMatricesCompatibleForMultiplication(matrix1, matrix2)) {
            double[][] result = new double[matrix1.length][matrix2[0].length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            displayMatrix("Result:", result);
        } else {
            System.out.println("Matrices are not compatible for multiplication.");
        }
    }

    private static void performMatrixTransposition(Scanner scanner) {
        double[][] matrix = getMatrixFromUser(scanner, "Enter the matrix:");

        double[][] result = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        displayMatrix("Result:", result);
    }

    private static double[][] getMatrixFromUser(Scanner scanner, String message) {
        System.out.println(message);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    private static void displayMatrix(String message, double[][] matrix) {
        System.out.println(message);
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean areMatricesCompatibleForOperation(double[][] matrix1, double[][] matrix2) {
        return matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length;
    }

    private static boolean areMatricesCompatibleForMultiplication(double[][] matrix1, double[][] matrix2) {
        return matrix1[0].length == matrix2.length;
    }

    private static double calculateNaturalLogarithm(double number) {
        return Math.log(number);
    }

    private static double calculateBase10Logarithm(double number) {
        return Math.log10(number);
    }

    private static double calculateBase2Logarithm(double number) {
        return Math.log(number) / Math.log(2);
    }
}
