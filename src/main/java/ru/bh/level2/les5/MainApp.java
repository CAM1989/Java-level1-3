package ru.bh.level2.les5;

public class MainApp {
    static final int size = 10000000;
    static final int half = size / 2;
    float[] arr = new float[size];

    public static void main(String[] args) {
        MainApp x = new MainApp();
        x.firstMethod();
        x.twoMethod();
    }

    public void writeOne() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) 1;
        }
    }

    public float[] rewriteOne(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    public void firstMethod() {
        writeOne();
        long a = System.currentTimeMillis();
        rewriteOne(arr);
        System.out.println("Time first method: " + (System.currentTimeMillis() - a));
    }

    public void twoMethod() {
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        writeOne();
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        Thread t1 = new Thread(() -> {
            float[] a1 = rewriteOne(arr1);
            System.arraycopy(a1, 0, arr1, 0, a1.length);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            float[] a2 = rewriteOne(arr2);
            System.arraycopy(a2, 0, arr2, 0, a2.length);
        });
        t2.start();

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        System.out.println("Time two method: " + (System.currentTimeMillis() - a));
    }

}