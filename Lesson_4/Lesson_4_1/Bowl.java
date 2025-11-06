package Lesson_4_1;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        setFoodAmount(foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        if (foodAmount < 0) {
            this.foodAmount = 0;
        } else {
            this.foodAmount = foodAmount;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount + " еды.");
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
}
