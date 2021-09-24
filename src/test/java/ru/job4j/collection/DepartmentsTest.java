package ru.job4j.collection;

import org.junit.Test;

import java.util.*;
import java.util.List;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMixed() {
        List<String> input = Arrays.asList("k1/sk1", "k2/sk1/ssk2");
        List<String> expect = List.of("k1", "k1/sk1", "k2", "k2/sk1",
                "k2/sk1/ssk2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortAsc() {
        String str1 = "K1";
        String str2 = "K1/SK1";
        String str3 = "K2/SK1/SSK2";
        String str4 = "K2";
        String str5 = "K1/SK2";
        List<String> list = Arrays.asList(str1, str2, str3, str4, str5);
        List<String> expected = List.of(str1, str2, str5, str4, str3);
        Departments.sortAsc(list);
        assertEquals(expected, list);
    }

    @Test
    public void whenSortDesc() {
        String str1 = "K1";
        String str2 = "K1/SK1";
        String str3 = "K2/SK1/SSK2";
        String str4 = "K2";
        String str5 = "K1/SK2";
        List<String> list = Arrays.asList(str1, str2, str3, str4, str5);
        List<String> expected = List.of(str4, str3, str1, str2, str5);
        Departments.sortDesc(list);
        assertEquals(expected, list);
    }
}