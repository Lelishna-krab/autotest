package Lesson_3_3;

import java.time.LocalTime;

public class Park {
    private String parkName;
    private String location;
    private Attraction[] attractions;
    private int attractionCount;

    public class Attraction {
        private String name;
        private LocalTime openingTime;
        private LocalTime closingTime;
        private double price;
        private int minAge;
        private String type;

        public Attraction(String name, LocalTime openingTime, LocalTime closingTime,
                          double price, int minAge, String type) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
            this.minAge = minAge;
            this.type = type;
        }

        public void printInfo() {
            System.out.println("<Информация об аттракционе>");
            System.out.println("Название: " + name);
            System.out.println("Время работы: " + openingTime + " - " + closingTime);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("Минимальный возраст: " + minAge + " лет");
            System.out.println("Тип: " + type);
            System.out.println("Парк: " + parkName);
            System.out.println("                            ");
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalTime getOpeningTime() {
            return openingTime;
        }

        public void setOpeningTime(LocalTime openingTime) {
            this.openingTime = openingTime;
        }

        public LocalTime getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(LocalTime closingTime) {
            this.closingTime = closingTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getMinAge() {
            return minAge;
        }

        public void setMinAge(int minAge) {
            this.minAge = minAge;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public Park(String parkName, String location, int maxAttractions) {
        this.parkName = parkName;
        this.location = location;
        this.attractions = new Attraction[maxAttractions];
        this.attractionCount = 0;
    }

    public void addAttraction(String name, LocalTime openingTime, LocalTime closingTime,
                              double price, int minAge, String type) {
        if (attractionCount < attractions.length) {
            attractions[attractionCount] = new Attraction(name, openingTime, closingTime, price, minAge, type);
            attractionCount++;
            System.out.println("Аттракцион '" + name + "' добавлен в парк '" + parkName + "'");
        } else {
            System.out.println("Достигнуто максимальное количество аттракционов!");
        }
    }

    public void printAllAttractions() {
        System.out.println("< ПАРК '" + parkName.toUpperCase() + "' >");
        System.out.println("Местоположение: " + location);
        System.out.println("Количество аттракционов: " + attractionCount);
        System.out.println("                          ");

        for (int i = 0; i < attractionCount; i++) {
            System.out.println("\nАттракцион #" + (i + 1) + ":");
            attractions[i].printInfo();
        }
    }
    public String getParkName() {
        return parkName;
    }

    public String getLocation() {
        return location;
    }

    public int getAttractionCount() {
        return attractionCount;
    }
}