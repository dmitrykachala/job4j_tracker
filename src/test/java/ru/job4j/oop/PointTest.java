package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance3d1() {
        Point a = new Point(0, 0, -1);
        Point b = new Point(4, 0, 12);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(13.601, 0.001));
    }

    @Test
    public void distance3d2() {
        Point a = new Point(-2, 10, -13);
        Point b = new Point(-15, 11, 42);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(56.524, 0.001));
    }
}