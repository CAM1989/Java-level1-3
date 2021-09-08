package ru.bh.level3.les1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> fruitBox;

    public Box (T... fruitBox) {
        this.fruitBox = new ArrayList<T>(Arrays.asList(fruitBox));
    }

    public float getWeight() {
        float weightBox = 0.0f;
        for (T type : fruitBox)
            weightBox = weightBox + type.getWeight();
        return weightBox;
    }

    public boolean compare(Box box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void clear() {
        fruitBox.clear();
    }

    public void transfer(Box<T> another) {
        if (this == another) {
            return;
        }
        another.fruitBox.addAll(this.fruitBox);
        clear();
    }

}
