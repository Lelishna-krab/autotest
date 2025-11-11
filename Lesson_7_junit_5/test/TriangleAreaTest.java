import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    // Позитивные тесты - корректные данные

    @Test
    @DisplayName("Площадь по основанию 10 и высоте 5 должна быть 25")
    void testAreaByBaseAndHeight() {
        assertEquals(25.0, TriangleArea.calculateAreaByBaseAndHeight(10, 5), 0.001);
    }

    @Test
    @DisplayName("Площадь по основанию 1 и высоте 1 должна быть 0.5")
    void testAreaWithOnes() {
        assertEquals(0.5, TriangleArea.calculateAreaByBaseAndHeight(1, 1), 0.001);
    }

    @Test
    @DisplayName("Площадь с дробными числами")
    void testAreaWithDecimals() {
        assertEquals(7.5, TriangleArea.calculateAreaByBaseAndHeight(3, 5), 0.001);
    }

    @Test
    @DisplayName("Площадь с большими числами")
    void testAreaWithLargeNumbers() {
        assertEquals(500000.0, TriangleArea.calculateAreaByBaseAndHeight(1000, 1000), 0.001);
    }

    @Test
    @DisplayName("Площадь с очень маленькими числами")
    void testAreaWithVerySmallNumbers() {
        assertEquals(0.00005, TriangleArea.calculateAreaByBaseAndHeight(0.001, 0.1), 0.000001);
    }

    // Параметризованные тесты

    @ParameterizedTest
    @DisplayName("Параметризованный тест площади по основанию и высоте")
    @CsvSource({
            "10, 5, 25.0",
            "4, 3, 6.0",
            "7.5, 2, 7.5",
            "1, 1, 0.5",
            "8, 6, 24.0",
            "12.5, 4, 25.0"
    })
    void testAreaByBaseAndHeightParameterized(double base, double height, double expected) {
        assertEquals(expected, TriangleArea.calculateAreaByBaseAndHeight(base, height), 0.001);
    }

    // Негативные тесты - некорректные данные

    @Test
    @DisplayName("Нулевое основание должно бросать исключение")
    void testAreaWithZeroBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(0, 5);
        });
    }

    @Test
    @DisplayName("Нулевая высота должна бросать исключение")
    void testAreaWithZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(10, 0);
        });
    }

    @Test
    @DisplayName("Оба нулевых параметра должны бросать исключение")
    void testAreaWithBothZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(0, 0);
        });
    }

    @Test
    @DisplayName("Отрицательное основание должно бросать исключение")
    void testAreaWithNegativeBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(-10, 5);
        });
    }

    @Test
    @DisplayName("Отрицательная высота должна бросать исключение")
    void testAreaWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(10, -5);
        });
    }

    @Test
    @DisplayName("Оба отрицательных параметра должны бросать исключение")
    void testAreaWithBothNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(-10, -5);
        });
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест отрицательных значений")
    @CsvSource({
            "-1, 5",
            "5, -1",
            "-1, -1",
            "0, 5",
            "5, 0",
            "0, 0"
    })
    void testAreaWithInvalidValuesParameterized(double base, double height) {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(base, height);
        });
    }

    // Тесты на граничные случаи

    @Test
    @DisplayName("Проверка точности вычислений с дробями")
    void testAreaPrecision() {
        double area = TriangleArea.calculateAreaByBaseAndHeight(1.234567, 9.876543);
        assertEquals(6.096, area, 0.001);
    }

    @Test
    @DisplayName("Проверка очень маленьких положительных чисел")
    void testAreaVerySmallPositiveNumbers() {
        double area = TriangleArea.calculateAreaByBaseAndHeight(0.0001, 0.0001);
        assertEquals(0.000000005, area, 0.000000001);
    }

    // Тесты на сообщения исключений

    @Test
    @DisplayName("Проверка сообщения исключения для отрицательных чисел")
    void testExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(-5, 10);
        });

        String expectedMessage = "Основание и высота должны быть положительными числами";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Проверка что исключение содержит ключевые слова")
    void testExceptionMessageContent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(0, 10);
        });

        String message = exception.getMessage();
        assertTrue(message.contains("Основание") || message.contains("высота") ||
                message.contains("положительными"));
    }
}