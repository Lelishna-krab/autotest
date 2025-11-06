package Lesson_4_2;

public interface Figure {
    String getFillColor();
    String getBorderColor();

    double calculatePerimeter();
    double calculateArea();

    default void printInfo() {
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()) +
                ", Площадь: " + String.format("%.2f", calculateArea()) +
                ", Цвет фона: " + getFillColor() +
                ", Цвет границ: " + getBorderColor());
    }

    default boolean isValidValue(double value) {
        return value > 0;
    }
}
