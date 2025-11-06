package Lesson_4_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");

        System.out.println("Тестирование бега и плавания");
        dog1.run(300);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        cat1.run(150);
        cat1.run(250);
        cat1.swim(5);

        System.out.println("\nРабота с миской");
        Bowl bowl = new Bowl(25);
        System.out.println("В миске initially: " + bowl.getFoodAmount() + " еды");

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        System.out.println("\n Кормление котов");
        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("\n Состояние котов");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + !cat.isHungry());
        }

        System.out.println("\n Добавляем еду и снова кормим");
        bowl.addFood(20);

        for (Cat cat : cats) {
            if (cat.isHungry()) {
                cat.eat(bowl);
            }
        }


        System.out.println("\n Итого");
        System.out.println("Всего животных: " + Animal.totalAnimals);
        System.out.println("Всего собак: " + Dog.totalDogs);
        System.out.println("Всего котов: " + Cat.totalCats);
    }
}