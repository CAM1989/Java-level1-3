package ru.bh.level1.les3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        //randomGame();
        guessGame();
    }

    private static void randomGame() {
        Random rand = new Random();
        int y = rand.nextInt(10);
        Scanner sc = new Scanner(System.in);
        System.out.println("Случайное число от 0 до 9 и дается 3 попытки угадать это число.");
        int x;
        for (int i = 0; i < 3; i++) {
            do {
                x = sc.nextInt();
            } while (x < 0 || x > 9);
            if (x == y) {
                System.out.println("Угадали!");
                break;
            } else if (x > y) {
                System.out.println("Введите меньше");
            } else if (x < y) {
                System.out.println("Введите больше");
            }
            if (i == 2 && x != y) {
                System.out.println("Не смогли угадать! =(");
            }
        }
        sc.close();
    }

    static String human;

    private static void guessGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        int y = rand.nextInt(words.length);
        String pc = words[y];
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nВыбери слово из списка: " + Arrays.toString(words));
            human = (sc.nextLine()).toLowerCase();
            for (int i = 0; i < pc.length(); i++) {
                char a = pc.charAt(i);
                for (int j = 0; j < human.length(); j++) {
                    char b = human.charAt(j);
                    if (a == b && i == j) {
                        System.out.print(a);
                        break;
                    } else if (j == (human.length() - 1)) {
                        System.out.print("#");
                    }
                }
            }
        } while (!pc.equals(human));
        sc.close();
        System.out.println("\nWin!");
    }
}

