package ru.bh.level2.les1;

public class Cat extends User {


    public Cat(String name, int energyDist, int energyJump) {
        this.name = name;
        this.energyDist = energyDist;
        this.energyJump = energyJump;
        this.onDist = true;
    }

    @Override
    public void run(int dist) {
        if (energyDist >= dist) {
            System.out.println("Кот " + name + " пробежал " + dist + "м");
        } else {
            System.out.println("Кот " + name + " не смог пробежать " + dist + "м");
            onDist = false;
        }
    }

    @Override
    public void jump(int height) {
        if (energyJump >= height) {
            System.out.println("Кот " + name + " перепрыгнул " + height + "м");
        } else {
            System.out.println("Кот " + name + " не смог перепрыгнуть " + height + "м");
            onDist = false;
        }
    }

}
