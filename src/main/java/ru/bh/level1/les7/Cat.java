package ru.bh.level1.les7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public void info() {
        if (satiety)
            System.out.println(name + " сыт");
        if (!satiety)
            System.out.println(name + " голоден");
    }

    public boolean eat(Plate p) {
        if (satiety == false && p.decreaseFood(appetite) == true) {
            return satiety = true;
        }
        return false;
    }
}