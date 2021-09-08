package ru.bh.level1.les2;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arr1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        les1(arr);
        les2(8);
        les3(arr1);
        les4(4);
        les5(arr1);
    }

    private static void les1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void les2(int a) {
        int[] arr = new int[a];
        int j = 0;
        for (int i = 0; i < a; i++) {
            arr[i] = j;
            j += 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void les3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void les4(int a) {
        int[][] arr = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j)
                    arr[i][j] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void les5(int[] arr) {
        int max = 0, min = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            min = a;
            if (a >= max) {
                max = a;
            } else if (a < min) {
                min = a;
            }
        }
        System.out.println(max + " " + min);
    }

}


