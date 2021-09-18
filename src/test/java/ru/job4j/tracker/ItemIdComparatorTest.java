package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemIdComparatorTest {

    @Test
    public void compare1() {
        Item item1 = new Item(3, "aaa");
        Item item2 = new Item(1, "mmm");
        Item item3 = new Item(13, "ggg");
        Item item4 = new Item(0, "ttt");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        List<Item> expected = Arrays.asList(item3, item1, item2, item4);
        Collections.sort(items, new ItemIdComparator());
        assertEquals(expected, items);
    }

    @Test
    public void compareMinus1() {
        Item item1 = new Item(3, "aaa");
        Item item2 = new Item(1, "mmm");
        Item item3 = new Item(13, "ggg");
        Item item4 = new Item(0, "ttt");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        List<Item> expected = Arrays.asList(item4, item2, item1, item3);
        Collections.sort(items, new ItemIdComparator().reversed());
        assertEquals(expected, items);
    }
}