import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {


    @Test
    @DisplayName("Факториал 0 должен быть равен 1")
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    @DisplayName("Факториал 1 должен быть равен 1")
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    @DisplayName("Факториал 2 должен быть равен 2")
    void testFactorialOfTwo() {
        assertEquals(2, FactorialCalculator.calculateFactorial(2));
    }

    @Test
    @DisplayName("Факториал 3 должен быть равен 6")
    void testFactorialOfThree() {
        assertEquals(6, FactorialCalculator.calculateFactorial(3));
    }

    @Test
    @DisplayName("Факториал 5 должен быть равен 120")
    void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    @DisplayName("Факториал 10 должен быть равен 3628800")
    void testFactorialOfTen() {
        assertEquals(3628800, FactorialCalculator.calculateFactorial(10));
    }

    @Test
    @DisplayName("Факториал 12 должен быть корректным")
    void testFactorialOfTwelve() {
        assertEquals(479001600, FactorialCalculator.calculateFactorial(12));
    }


    @ParameterizedTest
    @DisplayName("Параметризованный тест факториала для различных чисел")
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040",
            "8, 40320",
            "9, 362880",
            "10, 3628800",
            "11, 39916800",
            "12, 479001600"
    })
    void testFactorialVariousNumbers(int input, long expected) {
        assertEquals(expected, FactorialCalculator.calculateFactorial(input));
    }


    @Test
    @DisplayName("Факториал отрицательного числа должен бросать исключение")
    void testFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-5);
        });
    }

    @Test
    @DisplayName("Факториал -1 должен бросать исключение")
    void testFactorialOfMinusOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест отрицательных чисел")
    @ValueSource(ints = {-1, -5, -10, -100, -1000})
    void testFactorialNegativeNumbers(int negativeNumber) {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(negativeNumber);
        });
    }


    @Test
    @DisplayName("Факториал 20 должен быть корректным (проверка больших чисел)")
    void testFactorialOfTwenty() {
        assertEquals(2432902008176640000L, FactorialCalculator.calculateFactorial(20));
    }

    @Test
    @DisplayName("Факториал 15 должен быть корректным")
    void testFactorialOfFifteen() {
        assertEquals(1307674368000L, FactorialCalculator.calculateFactorial(15));
    }



    @Test
    @DisplayName("Проверка сообщения исключения для отрицательных чисел")
    void testExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-5);
        });

        String expectedMessage = "Факториал отрицательного числа не определен";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Проверка что исключение содержит ключевые слова")
    void testExceptionMessageContent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-10);
        });

        String message = exception.getMessage();
        assertTrue(message.contains("Факториал") ||
                message.contains("отрицательного") ||
                message.contains("не определен"));
    }



    @Test
    @DisplayName("Групповой тест нескольких факториалов")
    void testMultipleFactorials() {
        assertAll("Группа тестов факториала",
                () -> assertEquals(1, FactorialCalculator.calculateFactorial(0)),
                () -> assertEquals(1, FactorialCalculator.calculateFactorial(1)),
                () -> assertEquals(2, FactorialCalculator.calculateFactorial(2)),
                () -> assertEquals(6, FactorialCalculator.calculateFactorial(3)),
                () -> assertEquals(24, FactorialCalculator.calculateFactorial(4)),
                () -> assertEquals(120, FactorialCalculator.calculateFactorial(5))
        );
    }

    @Test
    @DisplayName("Факториал последовательных чисел должен быть согласованным")
    void testFactorialSequence() {
        long previous = 1; // 0! = 1
        for (int i = 1; i <= 10; i++) {
            long current = FactorialCalculator.calculateFactorial(i);
            assertEquals(previous * i, current,
                    "Факториал " + i + " должен быть равен " + (i) + " * " + previous);
            previous = current;
        }
    }



    @Test
    @DisplayName("Факториал 21 должен демонстрировать переполнение long")
    void testFactorialOverflow() {

        assertDoesNotThrow(() -> {
            long result = FactorialCalculator.calculateFactorial(21);

            assertTrue(result < 0, "21! должен вызывать переполнение long");
        });
    }
}