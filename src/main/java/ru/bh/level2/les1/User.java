package ru.bh.level2.les1;

public abstract class User implements Action {
    String name;
    int energyDist;
    int energyJump;
    boolean onDist;

    public boolean isOnDist() {
        return onDist;
    }
}
