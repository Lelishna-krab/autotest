import java.util.Scanner;

public class ArithmeticOperations {

    // Методы для арифметических операций
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("\nВыберите операцию:");
        System.out.println("1 - Сложение");
        System.out.println("2 - Вычитание");
        System.out.println("3 - Умножение");
        System.out.println("4 - Деление");
        System.out.print("Ваш выбор: ");

        int operation = scanner.nextInt();

        try {
            switch (operation) {
                case 1:
                    int sum = add(num1, num2);
                    System.out.println(num1 + " + " + num2 + " = " + sum);
                    break;
                case 2:
                    int difference = subtract(num1, num2);
                    System.out.println(num1 + " - " + num2 + " = " + difference);
                    break;
                case 3:
                    int product = multiply(num1, num2);
                    System.out.println(num1 + " * " + num2 + " = " + product);
                    break;
                case 4:
                    double quotient = divide(num1, num2);
                    System.out.println(num1 + " / " + num2 + " = " + quotient);
                    break;
                default:
                    System.out.println("Неверная операция!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}