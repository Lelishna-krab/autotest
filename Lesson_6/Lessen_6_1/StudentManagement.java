package Lessen_6_1;
import java.util.*;

public class StudentManagement {

    public static void removeFailedStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }


    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }


    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  - " + student.getName() + " (Группа: " + student.getGroup() +
                        ", Средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("  На данном курсе студентов не найдено");
        }
        System.out.println();
    }


    public static void printAllStudents(Set<Student> students) {
        System.out.println("Все студенты:");
        for (Student student : students) {
            System.out.println("  " + student);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();


        students.add(new Student("Иван Иванов", "ГР-01", 1,
                Map.of("Математика", 4, "Физика", 5, "Программирование", 5)));

        students.add(new Student("Петр Петров", "ГР-01", 1,
                Map.of("Математика", 3, "Физика", 2, "Программирование", 2)));

        students.add(new Student("Мария Сидорова", "ГР-02", 2,
                Map.of("Математика", 5, "Физика", 4, "Программирование", 5)));

        students.add(new Student("Анна Козлова", "ГР-02", 2,
                Map.of("Математика", 2, "Физика", 2, "Программирование", 3)));

        students.add(new Student("Алексей Смирнов", "ГР-03", 3,
                Map.of("Математика", 4, "Физика", 4, "Программирование", 4)));


        System.out.println("=== ДО ОПЕРАЦИЙ ===");
        printAllStudents(students);


        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);


        removeFailedStudents(students);
        System.out.println("=== ПОСЛЕ УДАЛЕНИЯ СТУДЕНТОВ С СРЕДНИМ БАЛЛОМ < 3 ===");
        printAllStudents(students);


        promoteStudents(students);
        System.out.println("=== ПОСЛЕ ПЕРЕВОДА НА СЛЕДУЮЩИЙ КУРС ===");
        printAllStudents(students);


        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);
    }
}
