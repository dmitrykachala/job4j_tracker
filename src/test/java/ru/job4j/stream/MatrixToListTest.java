package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.function.*;
import java.util.Map;
import java.util.stream.Stream;

public class MatrixToListTest {

    @Test
    public void matrixToList1() {
        Integer[][] integers = {{34, -3, 5, 6, 8},
                {1, 2, 3},
                {-1, 98, 45, 1, 0},
                {9, 3}};
        MatrixToList mtl = new MatrixToList();
        List<Integer> result = mtl.matrixToList(integers);
        List<Integer> expected = List.of(34, -3, 5, 6, 8, 1, 2, 3, -1, 98, 45, 1, 0, 9, 3);
        assertThat(result, is(expected));
    }

    @Test
    public void matrixToList2() {
        Integer[][] integers = {{34},
                {},
                {1, 0},
                {3}};
        MatrixToList mtl = new MatrixToList();
        List<Integer> result = mtl.matrixToList(integers);
        List<Integer> expected = List.of(34, 1, 0, 3);
        assertThat(result, is(expected));
    }
}