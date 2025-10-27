package Lessen_2_9;

public class Main {
    public static boolean isLeapYear(int year) {
             if (year % 400 == 0) {
            return true;
        }
               if (year % 100 == 0) {
            return false;
        }
               if (year % 4 == 0) {
            return true;
        }
              return false;
    }

    public static void main(String[] args) {
        // Тестирование метода
        System.out.println("2000: " + isLeapYear(2000)); // true
        System.out.println("1900: " + isLeapYear(1900)); // false
        System.out.println("2024: " + isLeapYear(2024)); // true
        System.out.println("2023: " + isLeapYear(2023)); // false
        System.out.println("1600: " + isLeapYear(1600)); // true
        System.out.println("1700: " + isLeapYear(1700)); // false
    }
}
