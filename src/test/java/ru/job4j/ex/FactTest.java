package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcMinus1() {
        Fact test = new Fact();
        test.calc(-1);
    }

    @Test
    public void calc0() {
        Fact test = new Fact();
        int expected = 1;
        test.calc(0);
        assertEquals(expected, 1);
    }
}