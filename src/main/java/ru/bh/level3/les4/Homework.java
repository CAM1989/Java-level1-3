package ru.bh.level3.les4;

public class Homework {
   //Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок –ABСABСABС). Используйте wait/notify/notifyAll.
   static class WaitNotifyClass {
       private final Object mon = new Object();
       private char currentLetter = 'A';

       public void printA() {
           synchronized (mon) {
               try {
                   for (int i = 0; i < 5; i++) {
                       while (currentLetter != 'A') {
                           mon.wait();
                       }
                       System.out.print("A");
                       currentLetter = 'B';
                       mon.notifyAll();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }

       public void printB() {
           synchronized (mon) {
               try {
                   for (int i = 0; i < 5; i++) {
                       while (currentLetter != 'B') {
                           mon.wait();
                       }
                       System.out.print("B");
                       currentLetter = 'C';
                       mon.notifyAll();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }

       public void printC() {
           synchronized (mon) {
               try {
                   for (int i = 0; i < 5; i++) {
                       while (currentLetter != 'C') {
                           mon.wait();
                       }
                       System.out.print("C ");
                       currentLetter = 'A';
                       mon.notifyAll();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }

    public static void main(String[] args) {

        WaitNotifyClass waitNotifyClass = new WaitNotifyClass();
        new Thread(() -> {
            waitNotifyClass.printA();
        }).start();
        new Thread(() -> {
            waitNotifyClass.printB();
        }).start();
        new Thread(() -> {
            waitNotifyClass.printC();
        }).start();


    }
}
