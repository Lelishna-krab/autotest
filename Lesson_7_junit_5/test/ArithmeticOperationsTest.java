import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {


    @Test
    @DisplayName("Сложение положительных чисел")
    void testAdditionPositiveNumbers() {
        assertEquals(15, ArithmeticOperations.add(10, 5));
    }

    @Test
    @DisplayName("Сложение отрицательных чисел")
    void testAdditionNegativeNumbers() {
        assertEquals(-15, ArithmeticOperations.add(-10, -5));
    }

    @Test
    @DisplayName("Сложение положительного и отрицательного числа")
    void testAdditionMixedNumbers() {
        assertEquals(5, ArithmeticOperations.add(10, -5));
    }

    @Test
    @DisplayName("Сложение с нулем")
    void testAdditionWithZero() {
        assertEquals(10, ArithmeticOperations.add(10, 0));
        assertEquals(5, ArithmeticOperations.add(0, 5));
        assertEquals(0, ArithmeticOperations.add(0, 0));
    }


    @Test
    @DisplayName("Вычитание положительных чисел")
    void testSubtractionPositiveNumbers() {
        assertEquals(5, ArithmeticOperations.subtract(10, 5));
    }

    @Test
    @DisplayName("Вычитание отрицательных чисел")
    void testSubtractionNegativeNumbers() {
        assertEquals(-5, ArithmeticOperations.subtract(-10, -5));
    }

    @Test
    @DisplayName("Вычитание с нулем")
    void testSubtractionWithZero() {
        assertEquals(10, ArithmeticOperations.subtract(10, 0));
        assertEquals(-5, ArithmeticOperations.subtract(0, 5));
    }

    @Test
    @DisplayName("Вычитание дает отрицательный результат")
    void testSubtractionNegativeResult() {
        assertEquals(-5, ArithmeticOperations.subtract(5, 10));
    }


    @Test
    @DisplayName("Умножение положительных чисел")
    void testMultiplicationPositiveNumbers() {
        assertEquals(50, ArithmeticOperations.multiply(10, 5));
    }

    @Test
    @DisplayName("Умножение отрицательных чисел")
    void testMultiplicationNegativeNumbers() {
        assertEquals(50, ArithmeticOperations.multiply(-10, -5));
    }

    @Test
    @DisplayName("Умножение положительного на отрицательное")
    void testMultiplicationMixedNumbers() {
        assertEquals(-50, ArithmeticOperations.multiply(10, -5));
    }

    @Test
    @DisplayName("Умножение на ноль")
    void testMultiplicationWithZero() {
        assertEquals(0, ArithmeticOperations.multiply(10, 0));
        assertEquals(0, ArithmeticOperations.multiply(0, 5));
        assertEquals(0, ArithmeticOperations.multiply(0, 0));
    }

    @Test
    @DisplayName("Умножение на единицу")
    void testMultiplicationWithOne() {
        assertEquals(10, ArithmeticOperations.multiply(10, 1));
        assertEquals(5, ArithmeticOperations.multiply(1, 5));
    }


    @Test
    @DisplayName("Деление положительных чисел")
    void testDivisionPositiveNumbers() {
        assertEquals(2.0, ArithmeticOperations.divide(10, 5), 0.001);
    }

    @Test
    @DisplayName("Деление отрицательных чисел")
    void testDivisionNegativeNumbers() {
        assertEquals(2.0, ArithmeticOperations.divide(-10, -5), 0.001);
    }

    @Test
    @DisplayName("Деление положительного на отрицательное")
    void testDivisionMixedNumbers() {
        assertEquals(-2.0, ArithmeticOperations.divide(10, -5), 0.001);
    }

    @Test
    @DisplayName("Деление с десятичным результатом")
    void testDivisionWithDecimalResult() {
        assertEquals(3.333, ArithmeticOperations.divide(10, 3), 0.001);
    }

    @Test
    @DisplayName("Деление нуля на число")
    void testDivisionZeroByNumber() {
        assertEquals(0.0, ArithmeticOperations.divide(0, 5), 0.001);
    }

    @Test
    @DisplayName("Деление на единицу")
    void testDivisionByOne() {
        assertEquals(10.0, ArithmeticOperations.divide(10, 1), 0.001);
    }

    @Test
    @DisplayName("Деление на ноль должно бросать исключение")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(10, 0);
        });
    }

    @Test
    @DisplayName("Деление нуля на ноль должно бросать исключение")
    void testDivisionZeroByZero() {
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(0, 0);
        });
    }


    @ParameterizedTest
    @DisplayName("Параметризованный тест сложения")
    @CsvSource({
            "10, 5, 15",
            "-10, -5, -15",
            "10, -5, 5",
            "0, 5, 5",
            "10, 0, 10"
    })
    void testAdditionParameterized(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.add(a, b));
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест вычитания")
    @CsvSource({
            "10, 5, 5",
            "-10, -5, -5",
            "10, -5, 15",
            "5, 10, -5",
            "10, 0, 10"
    })
    void testSubtractionParameterized(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.subtract(a, b));
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест умножения")
    @CsvSource({
            "10, 5, 50",
            "-10, -5, 50",
            "10, -5, -50",
            "10, 0, 0",
            "0, 5, 0"
    })
    void testMultiplicationParameterized(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.multiply(a, b));
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест деления")
    @CsvSource({
            "10, 5, 2.0",
            "-10, -5, 2.0",
            "10, -5, -2.0",
            "0, 5, 0.0",
            "1, 2, 0.5"
    })
    void testDivisionParameterized(int a, int b, double expected) {
        assertEquals(expected, ArithmeticOperations.divide(a, b), 0.001);
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест деления на ноль")
    @CsvSource({
            "10, 0",
            "-5, 0",
            "0, 0",
            "1, 0"
    })
    void testDivisionByZeroParameterized(int a, int b) {
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(a, b);
        });
    }



    @Test
    @DisplayName("Операции с минимальными значениями int")
    void testOperationsWithMinInt() {
        assertEquals(Integer.MIN_VALUE + 1, ArithmeticOperations.add(Integer.MIN_VALUE, 1));
        assertDoesNotThrow(() -> ArithmeticOperations.multiply(Integer.MIN_VALUE, 1));
    }


    @Test
    @DisplayName("Проверка сообщения исключения при делении на ноль")
    void testDivisionByZeroExceptionMessage() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(10, 0);
        });

        String expectedMessage = "Деление на ноль!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Групповой тест всех операций с одинаковыми числами")
    void testAllOperationsWithSameNumbers() {
        int a = 8;
        int b = 4;

        assertAll("Все арифметические операции",
                () -> assertEquals(12, ArithmeticOperations.add(a, b)),
                () -> assertEquals(4, ArithmeticOperations.subtract(a, b)),
                () -> assertEquals(32, ArithmeticOperations.multiply(a, b)),
                () -> assertEquals(2.0, ArithmeticOperations.divide(a, b), 0.001)
        );
    }
}
