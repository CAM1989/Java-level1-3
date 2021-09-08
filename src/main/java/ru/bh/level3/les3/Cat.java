package ru.bh.level3.les3;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {
    private String color;
    private String name;
    private int age;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String color, String name, int age) {
        this.color = color;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + color + " " + age;
    }
}
