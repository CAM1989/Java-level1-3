package ru.bh.level2.les1;

public class Treadmill extends Device {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean doIt(User user) {
        user.run(length);
        return false;
    }

}
