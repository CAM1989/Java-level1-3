package ru.bh.level1.les6;

public class Cat extends Animal {
    static int catsCount = 0;

    public Cat(String name, String color) {
        catsCount++;
        this.type= "Кот";
        this.name = name;
        this.color = color;
        this.engRun = 200;
    }

    @Override
    public void voice() {
        System.out.println(name + ": мяу-мяу-мяу");
    }

    public static int getCatsCount() {
        return catsCount;
    }
}
