package Lessen_2_7;

public class Main {
    public static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isNegative(0));
        System.out.println(isNegative(1));
        System.out.println(isNegative(-1));
    }
}