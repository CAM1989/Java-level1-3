package ru.bh.level3.les6.ru.bh.level3.les6.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.bh.level3.les6.Calculator;

import java.util.Arrays;
import java.util.Collection;

public class CalculatorTests {
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 6, 5, 4, 2, 3, 3}, new int[]{2, 3, 3}},
                {new int[]{4, 3, 7, 5, 4, 4, 3, 2}, new int[]{3, 2}}
        });
    }

    private int[] in;
    private int[] out;

    public CalculatorTests(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private Calculator task1;

    @Before
    public void startTest() {
        task1 = new Calculator();
    }

    @Test
    public void testAfterLast4() {
        Assert.assertArrayEquals(out, Calculator.newArray(in));
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        Calculator.newArray(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }
}
