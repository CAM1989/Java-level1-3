package ru.bh.level1.les1;

public class MainApp {
    public static void main(String[] args) {
//    1
        byte b = 120;
        short sh = 234;
        int i = 123456;
        long l = 1235463L;
        float f = 122.3f;
        double d = -123.12;
        char c = '*';
        char c1 = '\u2234';
        boolean bool = false;
        System.out.println(c1);
//        2
        System.out.println(isSum(2, 3, 4, 3));
//        3
        System.out.println(edgeSum(15, 5));
//        4
        System.out.println(positiveNumber(15));
//        5
        System.out.println(posBool(-5));
//        6
        System.out.println(hiName("Mila"));
//        7
        System.out.println(leapYear(5));
    }

    private static float isSum(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean edgeSum(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20) {
            return true;
        } else return false;
    }

    private static String positiveNumber(int a) {
        String s;
        if (a >= 0) {
            return s = a + " Positive number";
        } else return s = a + " Negative number";
    }

    private static boolean posBool(int a) {
        if (a >= 0) {
            return false;
        } else return true;
    }

    private static String hiName(String a) {
        String s = "Hi, " + a + "!";
        return s;
    }

    private static String leapYear(int a) {
        String s;
        if (!(a % 4 == 0) || ((a % 100 == 0) && !(a % 400 == 0))) {
            return s = a + " No leap year";
        } else return s = a + " leap year!";
    }


}
