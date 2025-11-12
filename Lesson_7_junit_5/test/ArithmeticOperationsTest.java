import org.testng.annotations.*;
import org.testng.Assert;

public class ArithmeticOperationsTest {

    private ArithmeticOperations operations;

    @BeforeClass
    public void setUpClass() {
        operations = new ArithmeticOperations();
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Starting new test method...");
    }

    // Тесты для метода add()
    @Test
    public void testAddPositiveNumbers() {
        int result = ArithmeticOperations.add(5, 3);
        Assert.assertEquals(result, 8, "Сложение положительных чисел");
    }

    @Test
    public void testAddNegativeNumbers() {
        int result = ArithmeticOperations.add(-5, -3);
        Assert.assertEquals(result, -8, "Сложение отрицательных чисел");
    }

    @Test
    public void testAddPositiveAndNegative() {
        int result = ArithmeticOperations.add(5, -3);
        Assert.assertEquals(result, 2, "Сложение положительного и отрицательного числа");
    }

    @Test
    public void testAddWithZero() {
        int result = ArithmeticOperations.add(0, 5);
        Assert.assertEquals(result, 5, "Сложение с нулем");
    }

    // Тесты для метода subtract()
    @Test
    public void testSubtractPositiveNumbers() {
        int result = ArithmeticOperations.subtract(10, 3);
        Assert.assertEquals(result, 7, "Вычитание положительных чисел");
    }

    @Test
    public void testSubtractNegativeNumbers() {
        int result = ArithmeticOperations.subtract(-5, -3);
        Assert.assertEquals(result, -2, "Вычитание отрицательных чисел");
    }

    @Test
    public void testSubtractResultsInNegative() {
        int result = ArithmeticOperations.subtract(3, 5);
        Assert.assertEquals(result, -2, "Вычитание с отрицательным результатом");
    }

    @Test
    public void testSubtractZero() {
        int result = ArithmeticOperations.subtract(5, 0);
        Assert.assertEquals(result, 5, "Вычитание нуля");
    }

    // Тесты для метода multiply()
    @Test
    public void testMultiplyPositiveNumbers() {
        int result = ArithmeticOperations.multiply(4, 5);
        Assert.assertEquals(result, 20, "Умножение положительных чисел");
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        int result = ArithmeticOperations.multiply(-4, -5);
        Assert.assertEquals(result, 20, "Умножение отрицательных чисел");
    }

    @Test
    public void testMultiplyPositiveAndNegative() {
        int result = ArithmeticOperations.multiply(4, -5);
        Assert.assertEquals(result, -20, "Умножение положительного на отрицательное");
    }

    @Test
    public void testMultiplyByZero() {
        int result = ArithmeticOperations.multiply(5, 0);
        Assert.assertEquals(result, 0, "Умножение на ноль");
    }

    @Test
    public void testMultiplyByOne() {
        int result = ArithmeticOperations.multiply(5, 1);
        Assert.assertEquals(result, 5, "Умножение на единицу");
    }

    // Тесты для метода divide()
    @Test
    public void testDividePositiveNumbers() {
        double result = ArithmeticOperations.divide(10, 2);
        Assert.assertEquals(result, 5.0, 0.001, "Деление положительных чисел");
    }

    @Test
    public void testDivideNegativeNumbers() {
        double result = ArithmeticOperations.divide(-10, -2);
        Assert.assertEquals(result, 5.0, 0.001, "Деление отрицательных чисел");
    }

    @Test
    public void testDividePositiveByNegative() {
        double result = ArithmeticOperations.divide(10, -2);
        Assert.assertEquals(result, -5.0, 0.001, "Деление положительного на отрицательное");
    }

    @Test
    public void testDivideResultsInFraction() {
        double result = ArithmeticOperations.divide(5, 2);
        Assert.assertEquals(result, 2.5, 0.001, "Деление с дробным результатом");
    }

    @Test
    public void testDivideZeroByNumber() {
        double result = ArithmeticOperations.divide(0, 5);
        Assert.assertEquals(result, 0.0, 0.001, "Деление нуля на число");
    }

    // Тест на исключение при делении на ноль
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZeroThrowsException() {
        ArithmeticOperations.divide(10, 0);
    }

    @Test
    public void testDivideByZeroExceptionMessage() {
        try {
            ArithmeticOperations.divide(10, 0);
            Assert.fail("Ожидалось ArithmeticException");
        } catch (ArithmeticException e) {
            Assert.assertEquals(e.getMessage(), "Деление на ноль!");
        }
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Test method completed");
    }

    @AfterClass
    public void tearDownClass() {
        operations = null;
        System.out.println("All tests completed");
    }
}