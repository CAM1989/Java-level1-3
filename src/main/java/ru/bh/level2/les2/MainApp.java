package ru.bh.level2.les2;

public class MainApp {

    public static void main(String[] args) {

        String[][] arr = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "0", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        try {
            try {
                int sum = method(arr);
                System.out.println(sum);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива не корректный!");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Неверное значение массива.\n Посмотрите ячейку:" + e.j + "x" + e.i);
        }
    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4) {
                System.out.println("Некорректное количество столбцов");
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4) {
                    System.out.println("Некорректное количество строк.\nПосмотрите строку номер: " + (i + 1));
                    throw new MyArraySizeException();
                }
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return result;
    }
}
