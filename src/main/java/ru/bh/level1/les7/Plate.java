package ru.bh.level1.les7;

public class Plate {
    private int food;
    private int maxFood;

    public Plate(int food) {
        this.maxFood = food;
        if (food >= 0) {
            this.food = this.maxFood;
        } else {
            System.out.println("Введено некорректное значение!");
            this.maxFood = 0;
            return;
        }
    }

    public int getPlate() {
        return food;
    }

    public void setPlate(int food) {
        if (food >= 0) {
            this.food = food;
        } else {
            System.out.println("Введен некорректное значение!");
        }
    }

    public boolean decreaseFood(int n) {
        int decrease = food - n;
        if (decrease < 0) return false;
        else
            food -= n;
        return true;
    }

    public void addFood(int food) {
        this.food += food;
        System.out.println("Добавили " + food + " еды");
        if (this.food > maxFood) {
            System.out.println("Мало емкости");
            this.food = maxFood;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }


}
