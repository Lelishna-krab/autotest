package Lesson_4_1;

public class Animal {
    private String name;
    protected int maxRun;
    protected int maxSwim;

    public static int totalAnimals = 0;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум " + maxRun + " м.)");
        }
    }

    public void swim(int distance) {
        if (maxSwim == 0) {
            System.out.println(name + " не умеет плавать");
        } else if (distance <= maxSwim) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум " + maxSwim + " м.)");
        }
    }
}