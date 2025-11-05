package Lesson_3_3;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Park disneyland = new Park("Диснейленд", "Париж, Франция", 5);

        disneyland.addAttraction("Space Mountain", LocalTime.of(10, 0), LocalTime.of(20, 0), 1500, 12, "Горки");
        disneyland.addAttraction("Pirates of the Caribbean", LocalTime.of(9, 30), LocalTime.of(21, 0), 1200, 6, "Водный");
        disneyland.addAttraction("Big Thunder Mountain", LocalTime.of(10, 0), LocalTime.of(19, 30), 1400, 10, "Горки");
        disneyland.addAttraction("It's a Small World", LocalTime.of(9, 0), LocalTime.of(22, 0), 800, 0, "Водный");
        disneyland.addAttraction("Haunted Mansion", LocalTime.of(11, 0), LocalTime.of(18, 0), 1100, 8, "Тематический");

        disneyland.printAllAttractions();
    }
}