package Lessen_2_11;

public class Main {
    public static void main(String[] args) {
        int size = 100;
        int[] array = new int[size];

        if (array.length >= 1) {
            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }
        }

        System.out.println("Массив чисел от 1 до 100:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%3d ", array[i]);
            if ((i + 1) % 10 == 0) { // Переход на новую строку каждые 10 чисел
                System.out.println();
            }
        }
    }
}
