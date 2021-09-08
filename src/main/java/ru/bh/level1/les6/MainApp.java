package ru.bh.level1.les6;

public class MainApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", "Рыжий");
        Cat cat2 = new Cat("Барсик", "Рыжий");
        Cat cat3 = new Cat("Барсик", "Рыжий");
        Dog dog1 = new Dog("Бобик", "Черный");

        cat1.info();
        dog1.info();

        cat1.voice();
        dog1.voice();

        cat1.run(200);
        dog1.run(550);

        cat1.swim(50);
        dog1.swim(10);

        System.out.println(Cat.getCatsCount());

        System.out.println();
    }
}
