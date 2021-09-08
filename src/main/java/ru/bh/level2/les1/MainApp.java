package ru.bh.level2.les1;

public class MainApp {
    public static void main(String[] args) {

        User[] users = {
                new Cat("Murzik", 15, 4),
                new Human("Bob", 50, 2),
                new Robot("Android", 500, 500)
        };

        Device[] devices = {
                new Wall(1),
                new Treadmill(15),
                new Wall(10)
        };

        for (User u : users) {
            for (Device d : devices) {
                if (d.doIt(u)) ;
                if (!u.onDist) {
                    break;
                }
            }
        }
    }
}
