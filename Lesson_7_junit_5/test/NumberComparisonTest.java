import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparisonTest {



    @Test
    @DisplayName("Сравнение когда первое число больше")
    void testCompareFirstGreater() {
        assertEquals("10 > 5", NumberComparison.compareNumbers(10, 5));
    }

    @Test
    @DisplayName("Сравнение когда первое число меньше")
    void testCompareFirstLess() {
        assertEquals("5 < 10", NumberComparison.compareNumbers(5, 10));
    }

    @Test
    @DisplayName("Сравнение равных чисел")
    void testCompareEqualNumbers() {
        assertEquals("Числа равны", NumberComparison.compareNumbers(5, 5));
    }

    @Test
    @DisplayName("Сравнение отрицательных чисел (первое больше)")
    void testCompareNegativeNumbersFirstGreater() {
        assertEquals("-5 > -10", NumberComparison.compareNumbers(-5, -10));
    }

    @Test
    @DisplayName("Сравнение отрицательных чисел (первое меньше)")
    void testCompareNegativeNumbersFirstLess() {
        assertEquals("-10 < -5", NumberComparison.compareNumbers(-10, -5));
    }

    @Test
    @DisplayName("Сравнение положительного и отрицательного чисел")
    void testComparePositiveAndNegative() {
        assertEquals("5 > -5", NumberComparison.compareNumbers(5, -5));
    }

    @Test
    @DisplayName("Сравнение с нулем (первое положительное)")
    void testCompareWithZeroPositive() {
        assertEquals("5 > 0", NumberComparison.compareNumbers(5, 0));
    }

    @Test
    @DisplayName("Сравнение с нулем (первое отрицательное)")
    void testCompareWithZeroNegative() {
        assertEquals("-5 < 0", NumberComparison.compareNumbers(-5, 0));
    }

    @Test
    @DisplayName("Сравнение двух нулей")
    void testCompareTwoZeros() {
        assertEquals("Числа равны", NumberComparison.compareNumbers(0, 0));
    }



    @ParameterizedTest
    @DisplayName("Параметризованный тест сравнения чисел")
    @CsvSource({
            "10, 5, '10 > 5'",
            "5, 10, '5 < 10'",
            "5, 5, 'Числа равны'",
            "-5, -10, '-5 > -10'",
            "-10, -5, '-10 < -5'",
            "0, 0, 'Числа равны'",
            "100, -100, '100 > -100'",
            "-50, 50, '-50 < 50'"
    })
    void testCompareNumbersParameterized(int a, int b, String expected) {
        assertEquals(expected, NumberComparison.compareNumbers(a, b));
    }



    @Test
    @DisplayName("Проверка равенства одинаковых чисел")
    void testAreNumbersEqualTrue() {
        assertTrue(NumberComparison.areNumbersEqual(5, 5));
    }

    @Test
    @DisplayName("Проверка равенства разных чисел")
    void testAreNumbersEqualFalse() {
        assertFalse(NumberComparison.areNumbersEqual(5, 10));
    }

    @Test
    @DisplayName("Проверка равенства отрицательных чисел")
    void testAreNumbersEqualNegative() {
        assertTrue(NumberComparison.areNumbersEqual(-5, -5));
    }

    @Test
    @DisplayName("Проверка равенства с нулем")
    void testAreNumbersEqualWithZero() {
        assertTrue(NumberComparison.areNumbersEqual(0, 0));
    }



    @Test
    @DisplayName("Максимальное число когда первое больше")
    void testGetMaxFirstGreater() {
        assertEquals(10, NumberComparison.getMax(10, 5));
    }

    @Test
    @DisplayName("Максимальное число когда второе больше")
    void testGetMaxSecondGreater() {
        assertEquals(10, NumberComparison.getMax(5, 10));
    }

    @Test
    @DisplayName("Максимальное число когда числа равны")
    void testGetMaxEqualNumbers() {
        assertEquals(5, NumberComparison.getMax(5, 5));
    }

    @Test
    @DisplayName("Максимальное число с отрицательными значениями")
    void testGetMaxWithNegatives() {
        assertEquals(-5, NumberComparison.getMax(-5, -10));
    }

    @Test
    @DisplayName("Максимальное число с положительным и отрицательным")
    void testGetMaxMixedNumbers() {
        assertEquals(5, NumberComparison.getMax(5, -5));
    }



    @Test
    @DisplayName("Минимальное число когда первое меньше")
    void testGetMinFirstLess() {
        assertEquals(5, NumberComparison.getMin(5, 10));
    }

    @Test
    @DisplayName("Минимальное число когда второе меньше")
    void testGetMinSecondLess() {
        assertEquals(5, NumberComparison.getMin(10, 5));
    }

    @Test
    @DisplayName("Минимальное число когда числа равны")
    void testGetMinEqualNumbers() {
        assertEquals(5, NumberComparison.getMin(5, 5));
    }

    @Test
    @DisplayName("Минимальное число с отрицательными значениями")
    void testGetMinWithNegatives() {
        assertEquals(-10, NumberComparison.getMin(-5, -10));
    }

    @Test
    @DisplayName("Минимальное число с положительным и отрицательным")
    void testGetMinMixedNumbers() {
        assertEquals(-5, NumberComparison.getMin(5, -5));
    }



    @Test
    @DisplayName("Разность положительных чисел (первое больше)")
    void testGetDifferencePositiveFirstGreater() {
        assertEquals(5, NumberComparison.getDifference(10, 5));
    }

    @Test
    @DisplayName("Разность положительных чисел (второе больше)")
    void testGetDifferencePositiveSecondGreater() {
        assertEquals(5, NumberComparison.getDifference(5, 10));
    }

    @Test
    @DisplayName("Разность одинаковых чисел")
    void testGetDifferenceEqualNumbers() {
        assertEquals(0, NumberComparison.getDifference(5, 5));
    }

    @Test
    @DisplayName("Разность отрицательных чисел")
    void testGetDifferenceNegativeNumbers() {
        assertEquals(5, NumberComparison.getDifference(-5, -10));
    }

    @Test
    @DisplayName("Разность положительного и отрицательного чисел")
    void testGetDifferenceMixedNumbers() {
        assertEquals(10, NumberComparison.getDifference(5, -5));
    }

    @Test
    @DisplayName("Разность с нулем")
    void testGetDifferenceWithZero() {
        assertEquals(5, NumberComparison.getDifference(5, 0));
        assertEquals(5, NumberComparison.getDifference(0, 5));
    }



    @ParameterizedTest
    @DisplayName("Параметризованный тест всех методов сравнения")
    @CsvSource({
            "10, 5, '10 > 5', false, 10, 5, 5",
            "5, 10, '5 < 10', false, 10, 5, 5",
            "5, 5, 'Числа равны', true, 5, 5, 0",
            "-5, -10, '-5 > -10', false, -5, -10, 5",
            "0, 0, 'Числа равны', true, 0, 0, 0"
    })
    void testAllMethodsParameterized(int a, int b, String expectedCompare,
                                     boolean expectedEqual, int expectedMax,
                                     int expectedMin, int expectedDiff) {
        assertEquals(expectedCompare, NumberComparison.compareNumbers(a, b));
        assertEquals(expectedEqual, NumberComparison.areNumbersEqual(a, b));
        assertEquals(expectedMax, NumberComparison.getMax(a, b));
        assertEquals(expectedMin, NumberComparison.getMin(a, b));
        assertEquals(expectedDiff, NumberComparison.getDifference(a, b));
    }



    @Test
    @DisplayName("Групповой тест граничных значений")
    void testBoundaryValues() {
        assertAll("Граничные значения сравнения",
                () -> assertEquals("0 > -1", NumberComparison.compareNumbers(0, -1)),
                () -> assertEquals("-1 < 0", NumberComparison.compareNumbers(-1, 0)),
                () -> assertEquals("2147483647 > -2147483648",
                        NumberComparison.compareNumbers(Integer.MAX_VALUE, Integer.MIN_VALUE)),
                () -> assertEquals("-2147483648 < 2147483647",
                        NumberComparison.compareNumbers(Integer.MIN_VALUE, Integer.MAX_VALUE))
        );
    }



    @Test
    @DisplayName("Проверка согласованности методов сравнения")
    void testMethodsConsistency() {
        int a = 7;
        int b = 3;

        String comparison = NumberComparison.compareNumbers(a, b);
        boolean areEqual = NumberComparison.areNumbersEqual(a, b);
        int max = NumberComparison.getMax(a, b);
        int min = NumberComparison.getMin(a, b);
        int diff = NumberComparison.getDifference(a, b);

        assertAll("Согласованность методов сравнения",
                () -> assertTrue(comparison.contains(">") && !areEqual,
                        "Если первое число больше, сравнение должно содержать '>' и числа не равны"),
                () -> assertEquals(a, max, "Максимум должен быть равен первому числу"),
                () -> assertEquals(b, min, "Минимум должен быть равен второму числу"),
                () -> assertEquals(a - b, diff, "Разность должна быть положительной")
        );
    }
}