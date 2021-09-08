package ru.bh.level1.les5;

public class Person {
    private String name, post, mail, phone;
    private int salary, age;

    public Person() {
        name = "Unknown";
        post = "Unknown";
        mail = "Unknown";
        phone = "Unknown";
        salary = 0;
        age = 0;
    }

    public Person(String name, String post, String mail, String phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Uncorrect age!");
        }
    }

    public void info() {
        System.out.printf("Name: %s, post: %s, email: %s, phone: %s, salary: %d, age: %d\n", name, post, mail, phone, salary, age);
    }

}

