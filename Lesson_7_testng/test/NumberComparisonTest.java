import org.testng.annotations.*;
import org.testng.Assert;

public class NumberComparisonTest {

    @BeforeClass
    public void setUpClass() {
        System.out.println("=== Начало тестирования NumberComparison ===");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("=== Завершение тестирования NumberComparison ===");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("--- Запуск теста ---");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("--- Завершение теста ---");
    }


    @Test
    public void testCompareNumbers_FirstGreater() {
        System.out.println("Тест: сравнение когда первое число больше");
        String result = NumberComparison.compareNumbers(10, 5);
        Assert.assertEquals(result, "10 > 5",
                "При 10 и 5 должно вернуться '10 > 5'");
    }

    @Test
    public void testCompareNumbers_SecondGreater() {
        System.out.println("Тест: сравнение когда второе число больше");
        String result = NumberComparison.compareNumbers(3, 8);
        Assert.assertEquals(result, "3 < 8",
                "При 3 и 8 должно вернуться '3 < 8'");
    }

    @Test
    public void testCompareNumbers_Equal() {
        System.out.println("Тест: сравнение когда числа равны");
        String result = NumberComparison.compareNumbers(7, 7);
        Assert.assertEquals(result, "Числа равны",
                "При 7 и 7 должно вернуться 'Числа равны'");
    }

    @Test
    public void testCompareNumbers_NegativeNumbers() {
        System.out.println("Тест: сравнение отрицательных чисел");
        String result = NumberComparison.compareNumbers(-5, -2);
        Assert.assertEquals(result, "-5 < -2",
                "При -5 и -2 должно вернуться '-5 < -2'");
    }

    @Test
    public void testCompareNumbers_ZeroAndPositive() {
        System.out.println("Тест: сравнение нуля и положительного числа");
        String result = NumberComparison.compareNumbers(0, 5);
        Assert.assertEquals(result, "0 < 5",
                "При 0 и 5 должно вернуться '0 < 5'");
    }

    @Test
    public void testCompareNumbers_ZeroAndNegative() {
        System.out.println("Тест: сравнение нуля и отрицательного числа");
        String result = NumberComparison.compareNumbers(0, -3);
        Assert.assertEquals(result, "0 > -3",
                "При 0 и -3 должно вернуться '0 > -3'");
    }


    @Test
    public void testAreNumbersEqual_True() {
        System.out.println("Тест: проверка равенства чисел (true)");
        boolean result = NumberComparison.areNumbersEqual(10, 10);
        Assert.assertTrue(result, "При 10 и 10 должно вернуться true");
    }

    @Test
    public void testAreNumbersEqual_False() {
        System.out.println("Тест: проверка равенства чисел (false)");
        boolean result = NumberComparison.areNumbersEqual(10, 20);
        Assert.assertFalse(result, "При 10 и 20 должно вернуться false");
    }

    @Test
    public void testAreNumbersEqual_Zero() {
        System.out.println("Тест: проверка равенства с нулем");
        boolean result = NumberComparison.areNumbersEqual(0, 0);
        Assert.assertTrue(result, "При 0 и 0 должно вернуться true");
    }

    @Test
    public void testAreNumbersEqual_Negative() {
        System.out.println("Тест: проверка равенства отрицательных чисел");
        boolean result = NumberComparison.areNumbersEqual(-5, -5);
        Assert.assertTrue(result, "При -5 и -5 должно вернуться true");
    }


    @Test
    public void testGetMax_FirstGreater() {
        System.out.println("Тест: максимальное число - первое");
        int result = NumberComparison.getMax(15, 10);
        Assert.assertEquals(result, 15, "Максимум из 15 и 10 должен быть 15");
    }

    @Test
    public void testGetMax_SecondGreater() {
        System.out.println("Тест: максимальное число - второе");
        int result = NumberComparison.getMax(5, 12);
        Assert.assertEquals(result, 12, "Максимум из 5 и 12 должен быть 12");
    }

    @Test
    public void testGetMax_Equal() {
        System.out.println("Тест: максимальное число при равенстве");
        int result = NumberComparison.getMax(7, 7);
        Assert.assertEquals(result, 7, "Максимум из 7 и 7 должен быть 7");
    }

    @Test
    public void testGetMax_NegativeNumbers() {
        System.out.println("Тест: максимальное из отрицательных чисел");
        int result = NumberComparison.getMax(-10, -5);
        Assert.assertEquals(result, -5, "Максимум из -10 и -5 должен быть -5");
    }


    @Test
    public void testGetMin_FirstSmaller() {
        System.out.println("Тест: минимальное число - первое");
        int result = NumberComparison.getMin(5, 10);
        Assert.assertEquals(result, 5, "Минимум из 5 и 10 должен быть 5");
    }

    @Test
    public void testGetMin_SecondSmaller() {
        System.out.println("Тест: минимальное число - второе");
        int result = NumberComparison.getMin(15, 8);
        Assert.assertEquals(result, 8, "Минимум из 15 и 8 должен быть 8");
    }

    @Test
    public void testGetMin_Equal() {
        System.out.println("Тест: минимальное число при равенстве");
        int result = NumberComparison.getMin(10, 10);
        Assert.assertEquals(result, 10, "Минимум из 10 и 10 должен быть 10");
    }

    @Test
    public void testGetMin_NegativeNumbers() {
        System.out.println("Тест: минимальное из отрицательных чисел");
        int result = NumberComparison.getMin(-3, -8);
        Assert.assertEquals(result, -8, "Минимум из -3 и -8 должен быть -8");
    }


    @Test
    public void testGetDifference_PositiveResult() {
        System.out.println("Тест: разность с положительным результатом");
        int result = NumberComparison.getDifference(10, 3);
        Assert.assertEquals(result, 7, "Разность между 10 и 3 должна быть 7");
    }

    @Test
    public void testGetDifference_NegativeResultBecomesPositive() {
        System.out.println("Тест: разность с модулем (отрицательное становится положительным)");
        int result = NumberComparison.getDifference(3, 10);
        Assert.assertEquals(result, 7, "Разность между 3 и 10 должна быть 7");
    }

    @Test
    public void testGetDifference_Zero() {
        System.out.println("Тест: разность равных чисел");
        int result = NumberComparison.getDifference(5, 5);
        Assert.assertEquals(result, 0, "Разность между 5 и 5 должна быть 0");
    }

    @Test
    public void testGetDifference_NegativeNumbers() {
        System.out.println("Тест: разность отрицательных чисел");
        int result = NumberComparison.getDifference(-5, -10);
        Assert.assertEquals(result, 5, "Разность между -5 и -10 должна быть 5");
    }

    @Test
    public void testGetDifference_PositiveAndNegative() {
        System.out.println("Тест: разность положительного и отрицательного");
        int result = NumberComparison.getDifference(5, -3);
        Assert.assertEquals(result, 8, "Разность между 5 и -3 должна быть 8");
    }


    @Test
    public void testAllMethodsTogether() {
        System.out.println("Тест: проверка всех методов вместе");
        int a = 15;
        int b = 10;


        String comparison = NumberComparison.compareNumbers(a, b);
        Assert.assertEquals(comparison, "15 > 10");


        boolean areEqual = NumberComparison.areNumbersEqual(a, b);
        Assert.assertFalse(areEqual);


        int max = NumberComparison.getMax(a, b);
        Assert.assertEquals(max, 15);


        int min = NumberComparison.getMin(a, b);
        Assert.assertEquals(min, 10);


        int difference = NumberComparison.getDifference(a, b);
        Assert.assertEquals(difference, 5);
    }

    @Test
    public void testAllMethodsWithEqualNumbers() {
        System.out.println("Тест: все методы с равными числами");
        int a = 7;
        int b = 7;

        Assert.assertEquals(NumberComparison.compareNumbers(a, b), "Числа равны");
        Assert.assertTrue(NumberComparison.areNumbersEqual(a, b));
        Assert.assertEquals(NumberComparison.getMax(a, b), 7);
        Assert.assertEquals(NumberComparison.getMin(a, b), 7);
        Assert.assertEquals(NumberComparison.getDifference(a, b), 0);
    }
}