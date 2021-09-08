package ru.bh.level3.les6;

import java.util.Arrays;

public class Calculator {
//    public static void main(String[] args) {
//        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        int arr2[] = {0, 2, 3, 0, 5, 6, 7, 8, 9, 0};
//        int arr3[] = {0, 0, 0, 4, 50};
//        int arr4[] = {1, 2, 4, 4, 2, 3, 4, 1, 7};
//    }

    public static int[] newArray(int[] arr) throws RuntimeException {
        int n = 0;
        String str = Arrays.toString(arr);
        if (str.indexOf(String.valueOf(4)) != -1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) n = i;
            }
            int[] arr1 = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
            return arr1;
        } else {
            throw new RuntimeException("4 не найдена");
        }
    }
}