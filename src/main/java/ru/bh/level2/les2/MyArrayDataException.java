package ru.bh.level2.les2;

public class MyArrayDataException extends RuntimeException{
    public int i;
    public int j;

    MyArrayDataException(int i, int j) {
        this.i = i+1;
        this.j = j+1;

    }

}
