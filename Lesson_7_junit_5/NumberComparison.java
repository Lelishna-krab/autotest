import java.util.Scanner;

public class NumberComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("\nРезультаты сравнения:");

        if (num1 > num2) {
            System.out.println(num1 + " > " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + " < " + num2);
        }

        if (num1 == num2) {
            System.out.println("Числа равны");
        } else {
            System.out.println("Числа не равны");
        }

        scanner.close();
    }
}
