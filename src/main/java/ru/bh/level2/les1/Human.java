package ru.bh.level2.les1;

public class Human extends User {

    public Human(String name, int energyDist, int energyJump) {
        this.name = name;
        this.energyDist = energyDist;
        this.energyJump = energyJump;
        this.onDist = true;
    }

    @Override
    public void run(int dist) {
        if (energyDist >= dist) {
            System.out.println("Человек по имени " + name + " пробежал " + dist + "м");
        } else {
            System.out.println("Человек по имени " + name + " не смог пробежать " + dist + "м");
            onDist = false;
        }
    }


    @Override
    public void jump(int height) {
        if (energyJump >= height) {
            System.out.println("Человек по имени " + name + " перепрыгнул " + height + "м");
        } else {
            System.out.println("Человек по имени " + name + " не смог перепрыгнуть " + height + "м");
            onDist = false;
        }
    }



}
