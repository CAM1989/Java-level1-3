package ru.bh.level1.les6;

public abstract class Animal {
    String type;
    String name;
    String color;
    int engRun;
    int engSwim;

    public void run(int a) {
        if (a > engRun) {
            System.out.println(type + " " + name + " не смогу пробежать " + a + " м");
        } else
            System.out.println(type + " " + name + " пробежал " + a + " м");
    }

    public void swim(int a) {
        if (engSwim == 0) {
            System.out.println(type + " " + name + " не умеет плавать!");
            return;
        }
        if (a > engSwim) {
            System.out.println(type + " " + name + " не смогу проплыть " + a + " м");
        } else
            System.out.println(type + " " + name + " проплыл " + a + " м");
    }

    public void info() {
        System.out.printf("%s, Имя: %s, Цвет: %s\n", type, name, color);
    }

    public abstract void voice();

}
