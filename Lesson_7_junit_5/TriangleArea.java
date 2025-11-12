import java.util.Scanner;

public class TriangleArea {

    public static double calculateAreaByBaseAndHeight(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными числами");
        }
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        calculateAndPrintAreaByBaseAndHeight(scanner);

        scanner.close();
    }


    private static void calculateAndPrintAreaByBaseAndHeight(Scanner scanner) {
        System.out.print("Введите длину основания: ");
        double base = scanner.nextDouble();

        System.out.print("Введите высоту: ");
        double height = scanner.nextDouble();

        try {
            double area = calculateAreaByBaseAndHeight(base, height);
            System.out.printf("Площадь треугольника = %.2f\n", area);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}