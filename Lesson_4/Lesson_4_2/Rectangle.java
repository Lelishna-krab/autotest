package Lesson_4_2;

public class Rectangle implements Figure {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        if (isValidValue(width) && isValidValue(height)) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами");
        }
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void printInfo() {
        System.out.print("Прямоугольник: ");
        Figure.super.printInfo();
    }
}