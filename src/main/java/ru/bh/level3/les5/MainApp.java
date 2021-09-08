package ru.bh.level3.les5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainApp {
    public static void main(String[] args) {
        exampleCyclicBarrier();
    }

    private static void exampleCyclicBarrier() {
        int countCb = 3;
        CyclicBarrier cb = new CyclicBarrier(countCb);//создает 3 потока и ждет, пока каждый из них не приготовится к работе
        for (int i = 0; i < countCb; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Поток " + w + " готовится");
                    Thread.sleep(100 + (int) (3000 * Math.random()));
                    System.out.println("Поток " + w + " готов");
                    cb.await();
                    System.out.println("Поток " + w + " запустился");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void exampleCountDownLatch() {
        // задаем количество потоков
        final int THREADS_COUNT = 6;
// задаем значение счётчика
        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);/*ожидает завершения операций, выполняющихся в других потоках*/
        System.out.println("Начинаем");
        for (int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
// считаем, что выполнение задачи занимает ~1 сек
                    Thread.sleep(500 + (int)(500 * Math.random()));
                    cdl.countDown();/*уменьшает количество операций*/
// как только задача выполнена, уменьшаем счётчик
                    System.out.println("Поток #" + w + " - готов");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl.await();//режим ожидания
// пока счётчик не приравняется нулю, будем стоять на этой строке
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
// как только все потоки выполнили свои задачи - пишем сообщение
        System.out.println("Работа завершена");
    }

    private static void exampleSemaphore() {
        Semaphore smp = new Semaphore(2);//одновременно захватить семафор могут только два потока
        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Поток " + w + " перед семафором");
                    smp.acquire(); //для получения доступа
                    System.out.println("Поток " + w + " получил доступ к ресурсу");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Поток " + w + " освободил ресурс");
                    smp.release();//для освобождения
                }
            }).start();
        }
    }
}
