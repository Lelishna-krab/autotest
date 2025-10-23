package Lessen_2_5;

public class Main {
    public static boolean checkSumRange(int a, int b) {
        int sum = a+b;
        if (sum >= 10 && sum <=20) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(checkSumRange(4, 5));
        System.out.println(checkSumRange(5, 5));
        System.out.println(checkSumRange(5, 6));
        System.out.println(checkSumRange(10, 9));
        System.out.println(checkSumRange(10, 10));
        System.out.println(checkSumRange(10, 11));
    }
}