import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        calculateAreaByBaseAndHeight(scanner);

        scanner.close();
    }

    public static void calculateAreaByBaseAndHeight(Scanner scanner) {
        System.out.print("Введите длину основания: ");
        double base = scanner.nextDouble();

        System.out.print("Введите высоту: ");
        double height = scanner.nextDouble();

        double area = 0.5 * base * height;
        System.out.printf("Площадь треугольника = %.2f\n", area);
    }
}