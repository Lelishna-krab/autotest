package Lessen_6_2;
import java.util.*;

 public class PhoneDirectory {
        private Map<String, List<String>> directory;

        public PhoneDirectory() {
            directory = new HashMap<>();
        }

        public void add(String lastName, String phoneNumber) {
            directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
        }

        public List<String> get(String lastName) {
            return directory.getOrDefault(lastName, Collections.emptyList());
        }


        public void findAndPrint(String lastName) {
            List<String> phones = get(lastName);
            if (phones.isEmpty()) {
                System.out.println("Фамилия '" + lastName + "' не найдена в справочнике.");
            } else {
                System.out.println("Найдено для '" + lastName + "':");
                for (int i = 0; i < phones.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + phones.get(i));
                }
            }
        }

        public void printAll() {
            System.out.println("< ТЕЛЕФОННЫЙ СПРАВОЧНИК >");
            if (directory.isEmpty()) {
                System.out.println("Справочник пуст");
                return;
            }

            for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
                System.out.print(entry.getKey() + ": ");
                System.out.println(String.join(", ", entry.getValue()));
            }
        }

        public static void main(String[] args) {
            PhoneDirectory phoneBook = new PhoneDirectory();

            // Добавляем тестовые данные
            phoneBook.add("Иванов", "8-911-111-11-11");
            phoneBook.add("Петров", "8-922-222-22-22");
            phoneBook.add("Сидоров", "8-933-333-33-33");
            phoneBook.add("Иванов", "8-944-444-44-44");
            phoneBook.add("Петров", "8-955-555-55-55");
            phoneBook.add("Иванов", "8-966-666-66-66");

            // Выводим весь справочник
            phoneBook.printAll();

            System.out.println("\n< ПОИСК >");

            // Тестируем поиск
            phoneBook.findAndPrint("Иванов");
            phoneBook.findAndPrint("Петров");
            phoneBook.findAndPrint("Сидоров");
            phoneBook.findAndPrint("Неизвестнов");
        }

}
