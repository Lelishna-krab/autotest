package Lesson_4_1;

public class Dog extends Animal {
    public static int totalDogs = 0;

    public Dog(String name) {
        super(name);
        this.maxRun = 500;
        this.maxSwim = 10;
        totalDogs++;
    }
}
