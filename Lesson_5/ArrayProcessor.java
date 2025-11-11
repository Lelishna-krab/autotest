public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Неверное количество строк. Ожидается: 4, получено: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Неверное количество столбцов в строке " + i +
                        ". Ожидается: 4, получено: " + array[i].length);
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" +
                            array[i][j] + "'");
                }
            }
        }

        return sum;
    }

    /**
     * Метод для генерации и поимки ArrayIndexOutOfBoundsException
     */
    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\nДемонстрация ArrayIndexOutOfBoundsException");

        int[] smallArray = new int[3];

        try {

            System.out.println("Попытка доступа к элементу с индексом 5...");
            int value = smallArray[5];
            System.out.println("Значение: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Причина: попытка доступа к индексу за пределами массива");
        }

        try {

            System.out.println("\nПопытка доступа к элементу с индексом -1...");
            int value = smallArray[-1];
            System.out.println("Значение: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Причина: отрицательный индекс массива");
        }
    }
    public static void main(String[] args) {


        System.out.println("Тест 1: Корректный массив");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("\nТест 2: Массив с неверным размером");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = processArray(wrongSizeArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        System.out.println("\nТест 3: Массив с нечисловыми данными");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }


        System.out.println("\nТест 4: Массив с пустыми строками ");
        String[][] emptyDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(emptyDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }


        demonstrateArrayIndexOutOfBounds();
    }
}
