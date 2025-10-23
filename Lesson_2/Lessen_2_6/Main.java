package Lessen_2_6;

public class Main {
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
    public static void main(String[] args) {
        checkNumber(5);
        checkNumber(-5);
        checkNumber(0);
    }
}