package Lessen_2_14;

public class Main {
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] result1 = createArray(5, 1);
        System.out.println("Массив 1: " + java.util.Arrays.toString(result1));

        int[] result2 = createArray(3, -11);
        System.out.println("Массив 2: " + java.util.Arrays.toString(result2));

        int[] result3 = createArray(1, 111); // Пустой массив
        System.out.println("Массив 3: " + java.util.Arrays.toString(result3));
    }
}
