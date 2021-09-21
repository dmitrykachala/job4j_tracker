package ru.job4j.lambda;

import org.junit.Test;
import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LambdaUsageTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = LambdaUsage.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = LambdaUsage.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExpFunctionThenExpResults() {
        List<Double> result = LambdaUsage.diapason(1, 3, x -> Math.pow(x, x) + 1);
        List<Double> expected = Arrays.asList(2D, 5D);
        assertThat(result, is(expected));
    }
}