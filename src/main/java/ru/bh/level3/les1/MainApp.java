package ru.bh.level3.les1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        String[] arr1 = {"1", "2", "3", "4", "5", "6"};
        String[] arr2 = {"A", "B", "C", "D", "E", "F"};
        swap(arr1, 1, 2);
        System.out.println(Arrays.toString(arr2));
        toArrayList(arr2);

        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange(), new Orange());
        Box<Orange> anotherOrangeBox = new Box<>(new Orange());
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        anotherOrangeBox.transfer(orangeBox);
        System.out.println(orangeBox.getWeight());
    }

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    private static void swap(String[] arr1, int i, int i1) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i1 < 0 || i > arr1.length || i1 > arr1.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid value replace element");
        }
        String j = arr1[i - 1];
        arr1[i - 1] = arr1[i1 - 1];
        arr1[i1 - 1] = j;
        System.out.println(Arrays.toString(arr1));
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> toArrayList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Converted array: " + arrayList);
        return arrayList;
    }
}
