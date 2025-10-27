package Lessen_2_8;

public class Main {
    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(i + ": " + text);
        }
    }

    public static void main(String[] args) {
        printStringMultipleTimes("Привет", 5);
    }
}