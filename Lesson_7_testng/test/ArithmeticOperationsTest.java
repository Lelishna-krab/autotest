import org.testng.annotations.*;
import org.testng.Assert;

public class ArithmeticOperationsTest {

    @BeforeClass
    public void setUpClass() {
        System.out.println(" Начало тестирования ArithmeticOperations ");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println(" Завершение тестирования ArithmeticOperations ");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println(" Запуск теста ");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println(" Завершение теста ");
    }


    @Test
    public void testAdditionBasic() {
        System.out.println("Тест: сложение положительных чисел");
        int result = ArithmeticOperations.add(5, 3);
        Assert.assertEquals(result, 8, "5 + 3 должно быть 8");
    }

    @Test
    public void testAdditionWithNegative() {
        System.out.println("Тест: сложение с отрицательными числами");
        int result = ArithmeticOperations.add(5, -3);
        Assert.assertEquals(result, 2, "5 + (-3) должно быть 2");
    }

    @Test
    public void testAdditionZero() {
        System.out.println("Тест: сложение с нулем");
        int result = ArithmeticOperations.add(0, 5);
        Assert.assertEquals(result, 5, "0 + 5 должно быть 5");
    }


    @Test
    public void testSubtractionBasic() {
        System.out.println("Тест: вычитание положительных чисел");
        int result = ArithmeticOperations.subtract(10, 4);
        Assert.assertEquals(result, 6, "10 - 4 должно быть 6");
    }

    @Test
    public void testSubtractionNegativeResult() {
        System.out.println("Тест: вычитание с отрицательным результатом");
        int result = ArithmeticOperations.subtract(3, 5);
        Assert.assertEquals(result, -2, "3 - 5 должно быть -2");
    }


    @Test
    public void testMultiplicationBasic() {
        System.out.println("Тест: умножение положительных чисел");
        int result = ArithmeticOperations.multiply(4, 5);
        Assert.assertEquals(result, 20, "4 * 5 должно быть 20");
    }

    @Test
    public void testMultiplicationByZero() {
        System.out.println("Тест: умножение на ноль");
        int result = ArithmeticOperations.multiply(5, 0);
        Assert.assertEquals(result, 0, "5 * 0 должно быть 0");
    }

    @Test
    public void testMultiplicationNegative() {
        System.out.println("Тест: умножение отрицательных чисел");
        int result = ArithmeticOperations.multiply(-4, -5);
        Assert.assertEquals(result, 20, "(-4) * (-5) должно быть 20");
    }


    @Test
    public void testDivisionBasic() {
        System.out.println("Тест: деление положительных чисел");
        double result = ArithmeticOperations.divide(10, 2);
        Assert.assertEquals(result, 5.0, 0.001, "10 / 2 должно быть 5.0");
    }

    @Test
    public void testDivisionFraction() {
        System.out.println("Тест: деление с дробным результатом");
        double result = ArithmeticOperations.divide(5, 2);
        Assert.assertEquals(result, 2.5, 0.001, "5 / 2 должно быть 2.5");
    }

    @Test
    public void testDivisionByOne() {
        System.out.println("Тест: деление на единицу");
        double result = ArithmeticOperations.divide(7, 1);
        Assert.assertEquals(result, 7.0, 0.001, "7 / 1 должно быть 7.0");
    }


    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        System.out.println("Тест: деление на ноль (ожидается исключение)");
        ArithmeticOperations.divide(10, 0);
    }

    @Test
    public void testDivisionByZeroMessage() {
        System.out.println("Тест: проверка сообщения об ошибке при делении на ноль");
        try {
            ArithmeticOperations.divide(10, 0);
            Assert.fail("Ожидалось ArithmeticException");
        } catch (ArithmeticException e) {
            Assert.assertEquals(e.getMessage(), "Деление на ноль!",
                    "Сообщение об ошибке должно быть 'Деление на ноль!'");
        }
    }


    @Test
    public void testAllOperations() {
        System.out.println("Тест: проверка всех операций вместе");


        Assert.assertEquals(ArithmeticOperations.add(2, 3), 5);


        Assert.assertEquals(ArithmeticOperations.subtract(5, 2), 3);


        Assert.assertEquals(ArithmeticOperations.multiply(3, 4), 12);


        Assert.assertEquals(ArithmeticOperations.divide(8, 2), 4.0, 0.001);
    }
}