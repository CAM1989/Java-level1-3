package ru.bh.level2.les4;

public class MainApp {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        MyThread mt1 = new MyThread();
        mt1.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
