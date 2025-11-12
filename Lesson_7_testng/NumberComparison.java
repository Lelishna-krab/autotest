import java.util.Scanner;

public class NumberComparison {


    public static String compareNumbers(int a, int b) {
        if (a > b) {
            return a + " > " + b;
        } else if (a < b) {
            return a + " < " + b;
        } else {
            return "Числа равны";
        }
    }


    public static boolean areNumbersEqual(int a, int b) {
        return a == b;
    }


    public static int getMax(int a, int b) {
        return Math.max(a, b);
    }


    public static int getMin(int a, int b) {
        return Math.min(a, b);
    }


    public static int getDifference(int a, int b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("\nРезультаты сравнения:");


        System.out.println(compareNumbers(num1, num2));

        if (areNumbersEqual(num1, num2)) {
            System.out.println("Числа равны");
        } else {
            System.out.println("Числа не равны");
            System.out.println("Максимальное число: " + getMax(num1, num2));
            System.out.println("Минимальное число: " + getMin(num1, num2));
            System.out.println("Разность: " + getDifference(num1, num2));
        }

        scanner.close();
    }
}