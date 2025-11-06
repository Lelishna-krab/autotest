package Lesson_4_1;

public class Cat extends Animal {
    private boolean isHungry;

    public static int totalCats = 0;

    public Cat(String name) {
        super(name);
        this.maxRun = 200;
        this.maxSwim = 0;
        this.isHungry = true;
        totalCats++;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            isHungry = false;
            System.out.println(getName() + " поел из миски и теперь сыт");
        } else {
            System.out.println(getName() + " не смог поесть: в миске недостаточно еды");
        }
    }

    public void eat(Bowl bowl) {
        eat(bowl, 10); // стандартная порция
    }
}
