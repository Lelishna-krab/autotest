import org.testng.annotations.*;
import org.testng.Assert;

public class TriangleAreaTest {

    private static final double DELTA = 0.0001;

    @BeforeClass
    public void setUpClass() {
        System.out.println(" Начало тестирования TriangleArea ");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println(" Завершение тестирования TriangleArea ");
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
    public void testCalculateAreaByBaseAndHeight_PositiveIntegers() {
        System.out.println("Тест: площадь с целыми положительными числами");
        double result = TriangleArea.calculateAreaByBaseAndHeight(10, 5);
        double expected = 0.5 * 10 * 5; // 25.0
        Assert.assertEquals(result, expected, DELTA,
                "Площадь треугольника с основанием 10 и высотой 5 должна быть 25.0");
    }

    @Test
    public void testCalculateAreaByBaseAndHeight_DecimalNumbers() {
        System.out.println("Тест: площадь с дробными числами");
        double result = TriangleArea.calculateAreaByBaseAndHeight(7.5, 4.2);
        double expected = 0.5 * 7.5 * 4.2; // 15.75
        Assert.assertEquals(result, expected, DELTA,
                "Площадь треугольника с основанием 7.5 и высотой 4.2 должна быть 15.75");
    }

    @Test
    public void testCalculateAreaByBaseAndHeight_One() {
        System.out.println("Тест: площадь с единичными значениями");
        double result = TriangleArea.calculateAreaByBaseAndHeight(1, 1);
        double expected = 0.5; // 0.5 * 1 * 1
        Assert.assertEquals(result, expected, DELTA,
                "Площадь треугольника с основанием 1 и высотой 1 должна быть 0.5");
    }

    @Test
    public void testCalculateAreaByBaseAndHeight_LargeNumbers() {
        System.out.println("Тест: площадь с большими числами");
        double result = TriangleArea.calculateAreaByBaseAndHeight(1000, 500);
        double expected = 0.5 * 1000 * 500; // 250000.0
        Assert.assertEquals(result, expected, DELTA,
                "Площадь треугольника с основанием 1000 и высотой 500 должна быть 250000.0");
    }

    @Test
    public void testCalculateAreaByBaseAndHeight_SmallDecimalNumbers() {
        System.out.println("Тест: площадь с маленькими дробными числами");
        double result = TriangleArea.calculateAreaByBaseAndHeight(0.1, 0.1);
        double expected = 0.5 * 0.1 * 0.1; // 0.005
        Assert.assertEquals(result, expected, DELTA,
                "Площадь треугольника с основанием 0.1 и высотой 0.1 должна быть 0.005");
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaByBaseAndHeight_NegativeBase() {
        System.out.println("Тест: отрицательное основание (ожидается исключение)");
        TriangleArea.calculateAreaByBaseAndHeight(-5, 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaByBaseAndHeight_NegativeHeight() {
        System.out.println("Тест: отрицательная высота (ожидается исключение)");
        TriangleArea.calculateAreaByBaseAndHeight(10, -5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaByBaseAndHeight_BothNegative() {
        System.out.println("Тест: оба параметра отрицательные (ожидается исключение)");
        TriangleArea.calculateAreaByBaseAndHeight(-5, -10);
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaByBaseAndHeight_ZeroBase() {
        System.out.println("Тест: нулевое основание (ожидается исключение)");
        TriangleArea.calculateAreaByBaseAndHeight(0, 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaByBaseAndHeight_ZeroHeight() {
        System.out.println("Тест: нулевая высота (ожидается исключение)");
        TriangleArea.calculateAreaByBaseAndHeight(10, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaByBaseAndHeight_BothZero() {
        System.out.println("Тест: оба параметра нулевые (ожидается исключение)");
        TriangleArea.calculateAreaByBaseAndHeight(0, 0);
    }


    @Test
    public void testCalculateAreaByBaseAndHeight_NegativeBaseExceptionMessage() {
        System.out.println("Тест: проверка сообщения исключения для отрицательного основания");
        try {
            TriangleArea.calculateAreaByBaseAndHeight(-5, 10);
            Assert.fail("Ожидалось IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Основание и высота должны быть положительными числами",
                    "Сообщение об ошибке должно быть 'Основание и высота должны быть положительными числами'");
        }
    }

    @Test
    public void testCalculateAreaByBaseAndHeight_ZeroHeightExceptionMessage() {
        System.out.println("Тест: проверка сообщения исключения для нулевой высоты");
        try {
            TriangleArea.calculateAreaByBaseAndHeight(10, 0);
            Assert.fail("Ожидалось IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Основание и высота должны быть положительными числами",
                    "Сообщение об ошибке должно быть 'Основание и высота должны быть положительными числами'");
        }
    }


    @Test
    public void testCalculateAreaByBaseAndHeight_VerySmallPositive() {
        System.out.println("Тест: очень маленькие положительные значения");
        double result = TriangleArea.calculateAreaByBaseAndHeight(0.0001, 0.0001);
        double expected = 0.5 * 0.0001 * 0.0001; // 5e-9
        Assert.assertEquals(result, expected, DELTA,
                "Площадь должна корректно вычисляться для очень маленьких положительных значений");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaByBaseAndHeight_VerySmallNegative() {
        System.out.println("Тест: очень маленькие отрицательные значения (ожидается исключение)");
        TriangleArea.calculateAreaByBaseAndHeight(-0.0001, 0.0001);
    }


    @Test
    public void testCalculateAreaByBaseAndHeight_Precision() {
        System.out.println("Тест: точность вычислений с дробными числами");
        double base = 3.3333333333;
        double height = 6.6666666666;
        double result = TriangleArea.calculateAreaByBaseAndHeight(base, height);
        double expected = 0.5 * base * height; // ~11.11111111108889
        Assert.assertEquals(result, expected, DELTA,
                "Вычисления должны быть точными с допустимой погрешностью");
    }
}