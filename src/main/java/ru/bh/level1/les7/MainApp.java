package ru.bh.level1.les7;

public class MainApp {
    public static void main(String[] args) {
        Cat[] cat = {
                new Cat("Barsik", 20),
                new Cat("Murzik", 15),
                new Cat("Gav", 5),
                new Cat("Felix", 10)

        };

        Plate plate = new Plate(20);

        for (int i = 0; i < cat.length; i++) {
            while (!cat[i].eat(plate)) {
                System.out.println("Коту " + cat[i].getName() + " мало еды в миске");
                plate.addFood(10);
            }
            cat[i].info();
        }
    }
}
