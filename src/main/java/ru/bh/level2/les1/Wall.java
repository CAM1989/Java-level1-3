package ru.bh.level2.les1;

public class Wall extends Device{
    private int height;


    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doIt(User user) {
        user.jump(height);
        return false;
    }
}
