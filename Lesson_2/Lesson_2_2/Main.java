package Lesson_2_2;

public class Main {
    public static void checkSumSign() {
        int a = 18;
        int b = -26;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void main(String[] args) {
        checkSumSign();
    }
}