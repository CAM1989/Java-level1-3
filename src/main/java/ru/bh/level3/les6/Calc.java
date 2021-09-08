package ru.bh.level3.les6;

import java.util.Arrays;

public class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

   public int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
