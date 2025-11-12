import org.testng.annotations.*;
import org.testng.Assert;

public class FactorialCalculatorTest {

    @BeforeClass
    public void setUpClass() {
        System.out.println(" Начало тестирования FactorialCalculator ");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println(" Завершение тестирования FactorialCalculator ");
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
    public void testFactorialOfZero() {
        System.out.println("Тест: факториал 0");
        long result = FactorialCalculator.calculateFactorial(0);
        Assert.assertEquals(result, 1L, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfOne() {
        System.out.println("Тест: факториал 1");
        long result = FactorialCalculator.calculateFactorial(1);
        Assert.assertEquals(result, 1L, "Факториал 1 должен быть 1");
    }


    @Test
    public void testFactorialOfTwo() {
        System.out.println("Тест: факториал 2");
        long result = FactorialCalculator.calculateFactorial(2);
        Assert.assertEquals(result, 2L, "Факториал 2 должен быть 2");
    }

    @Test
    public void testFactorialOfThree() {
        System.out.println("Тест: факториал 3");
        long result = FactorialCalculator.calculateFactorial(3);
        Assert.assertEquals(result, 6L, "Факториал 3 должен быть 6");
    }

    @Test
    public void testFactorialOfFive() {
        System.out.println("Тест: факториал 5");
        long result = FactorialCalculator.calculateFactorial(5);
        Assert.assertEquals(result, 120L, "Факториал 5 должен быть 120");
    }

    @Test
    public void testFactorialOfTen() {
        System.out.println("Тест: факториал 10");
        long result = FactorialCalculator.calculateFactorial(10);
        Assert.assertEquals(result, 3628800L, "Факториал 10 должен быть 3628800");
    }


    @Test
    public void testFactorialOfTwelve() {
        System.out.println("Тест: факториал 12");
        long result = FactorialCalculator.calculateFactorial(12);
        Assert.assertEquals(result, 479001600L, "Факториал 12 должен быть 479001600");
    }


    @Test
    public void testFactorialOfTwenty() {
        System.out.println("Тест: факториал 20 (проверка на границе переполнения)");
        long result = FactorialCalculator.calculateFactorial(20);

        Assert.assertEquals(result, 2432902008176640000L,
                "Факториал 20 должен быть 2432902008176640000");
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        System.out.println("Тест: факториал отрицательного числа (ожидается исключение)");
        FactorialCalculator.calculateFactorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfLargeNegativeNumber() {
        System.out.println("Тест: факториал большого отрицательного числа (ожидается исключение)");
        FactorialCalculator.calculateFactorial(-100);
    }

    @Test
    public void testNegativeFactorialExceptionMessage() {
        System.out.println("Тест: проверка сообщения об ошибке для отрицательного числа");
        try {
            FactorialCalculator.calculateFactorial(-5);
            Assert.fail("Ожидалось IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Факториал отрицательного числа не определен",
                    "Сообщение об ошибке должно быть 'Факториал отрицательного числа не определен'");
        }
    }
}