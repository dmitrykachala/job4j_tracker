package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcMinus1() {
        Fact test = new Fact();
        test.calc(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcMinus3() {
        Fact test = new Fact();
        test.calc(-1);
    }
}