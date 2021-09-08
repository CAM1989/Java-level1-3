package ru.bh.level3.les4;

import java.util.concurrent.*;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
//        fixedThreadPool();
//        interruptedByException();
//        example3();
    }

    private static void example3() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Java";
        });
        try {
            String s = future.get();
            System.out.println(s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private static void interruptedByException() throws InterruptedException {
        Thread t = new Thread(() -> {
            boolean interruptedByException = false;
            while (true) {
                if (Thread.currentThread().isInterrupted() || interruptedByException) {
                    break;
                }
                System.out.println(1);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    interruptedByException = true;
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        t.start();
        Thread.sleep(500);
        t.interrupt();
    }

    private static void fixedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println("START TASK");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("START END");
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("END");
    }
}
