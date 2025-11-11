import java.util.Scanner;

public class ArithmeticOperations {
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

        switch (operation) {
            case 1:
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case 2:
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case 3:
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                }
                break;
            default:
                System.out.println("Неверная операция!");
        }

        scanner.close();
    }
}
