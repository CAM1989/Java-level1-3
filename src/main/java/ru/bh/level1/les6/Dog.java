package ru.bh.level1.les6;

public class Dog extends Animal {
    static int dogsCount = 0;

    public Dog(String name, String color) {
        dogsCount++;
        this.type= "Собака";
        this.name = name;
        this.color = color;
        this.engRun = 500;
        this.engSwim = 10;
    }

    @Override
    public void voice() {
        System.out.println(name + ": гав-гав-гав");
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}
