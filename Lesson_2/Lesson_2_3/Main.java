package Lesson_2_3;

public class Main {
    public static void printColor(){
        int value = 101;
        if(value <=0) {
            System.out.println("Красный");
        }
        else if (value <=100){
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

    }
    public static void main(String[] args) {
        printColor();
    }
}