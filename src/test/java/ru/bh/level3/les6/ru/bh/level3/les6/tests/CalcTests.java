package ru.bh.level3.les6.ru.bh.level3.les6.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.bh.level3.les6.Calc;

public class CalcTests {
    private Calc calc;

    @BeforeAll
    public void init() {
        calc = new Calc();
        System.out.println("init created");
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(4, calc.add(2, 2));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals(10, calc.sub(20, 10));
    }

    @Test
    public void testMul() {
        Assertions.assertEquals(10, calc.mul(2, 5));
    }

    @Test
    public void testDiv() {
        Assertions.assertEquals(10, calc.div(20, 2));
    }
}

