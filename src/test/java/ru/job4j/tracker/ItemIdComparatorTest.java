package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemIdComparatorTest {

    @Test
    public void compare1() {
        List<Item> items = Arrays.asList(new Item(3, "aaa"), new Item(1, "mmm"),
                new Item(13, "ggg"), new Item(0, "ttt"));
        List<Item> expected = Arrays.asList(new Item(13, "ggg"), new Item(3, "aaa"),
                new Item(1, "mmm"), new Item(0, "ttt"));
        Collections.sort(items, new ItemIdComparator());
        assertEquals(expected.toString(), items.toString());
    }

    @Test
    public void compareMinus1() {
        List<Item> items = Arrays.asList(new Item(3, "aaa"), new Item(1, "mmm"),
                new Item(13, "ggg"), new Item(0, "ttt"));
        List<Item> expected = Arrays.asList(new Item(0, "ttt"), new Item(1, "mmm"),
                new Item(3, "aaa"), new Item(13, "ggg"));
        Collections.sort(items, new ItemIdComparator().reversed());
        assertEquals(expected.toString(), items.toString());
    }
}