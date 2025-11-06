package Lesson_4_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Расчет характеристик геометрических фигур\n");

        try {
            // Создаем фигуры
            Figure circle = new Circle(5.0, "Красный", "Черный");
            Figure rectangle = new Rectangle(4.0, 6.0, "Синий", "Белый");
            Figure triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Желтый");

            // Выводим информацию о фигурах
            circle.printInfo();
            rectangle.printInfo();
            triangle.printInfo();

            System.out.println("\nДополнительные фигуры\n");

            Figure bigCircle = new Circle(10.5, "Голубой", "Серый");
            Figure square = new Rectangle(5.0, 5.0, "Розовый", "Фиолетовый");
            Figure equilateralTriangle = new Triangle(6.0, 6.0, 6.0, "Оранжевый", "Коричневый");

            bigCircle.printInfo();
            square.printInfo();
            equilateralTriangle.printInfo();

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания фигуры: " + e.getMessage());
        }
    }
}
