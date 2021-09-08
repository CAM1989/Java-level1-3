package ru.bh.level1.les5;

public class MainApp {
    public static void main(String[] args) {
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Andreev Andrey", "Director", "anandrey@mailbox.com", "89123456780", 100000, 48);
        persArray[1] = new Person("Borisov Boris", "PR-manager", "borboris@mailbox.com", "89123456781", 35000, 40);
        persArray[2] = new Person("Petrov Petr", "Engineer", "petpetr@mailbox.com", "89123456782", 30000, 35);
        persArray[3] = new Person("Sergeev Sergey", "Senior engineer", "ssergey@mailbox.com", "89123456783", 50000, 42);
        persArray[4] = new Person("Ivanov Ivan", "IT specialist", "ivivan@mailbox.com", "89123456784", 40000, 30);

        Person per1 = new Person();
        Person per2 = new Person("Ivanov Ivan", "IT specialist", "ivivan@mailbox.com", "89123456789", 40000, 30);

        per1.info();
        per2.info();

        System.out.println(persArray[1].toString());

        for (Person p : persArray) {
            if (p.getAge() > 40) p.info();
        }
    }

}
