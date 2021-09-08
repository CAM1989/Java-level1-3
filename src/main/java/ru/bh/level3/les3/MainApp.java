package ru.bh.level3.les3;

import java.io.*;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cat.ser"))) {
            Cat cat1 = new Cat("White", "Barsik", 10);
            Cat cat2 = new Cat("Black", "Murzik", 5);
            System.out.println(cat1);
            System.out.println(cat2);
            out.writeObject(cat1);
            out.writeObject(cat2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cat.ser"))) {
            Cat inputCat1 = (Cat) in.readObject();
            Cat inputCat2 = (Cat) in.readObject();
            System.out.println(inputCat1);
            System.out.println(inputCat2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bufferReadAndWrite() {
        try (InputStream in = new BufferedInputStream(new FileInputStream("1.txt"))) {
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("1.txt"))) {
            for (int i = 0; i < 5 * 1024 * 1024; i++) {
                out.write(333);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] arrayWriteAndRead() {
        //запись кусками
        long t = System.currentTimeMillis();
        byte[] arr = new byte[1024];
        Arrays.fill(arr, (byte) 65);
        try (OutputStream out = new FileOutputStream("5mb.txt")) {
            for (int i = 0; i < 1024 * 5; i++) {
                out.write(arr);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - t);

        //Корректное чтение кусками
        byte[] data = new byte[64];
        try (FileInputStream in = new FileInputStream("5mb.txt")) {
            int len = 0;
            while ((len = in.read(data)) > 0) {
                System.out.println(new String(data, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
