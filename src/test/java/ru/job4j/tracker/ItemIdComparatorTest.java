package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemIdComparatorTest {

    @Test
    public void compare1() {
        ItemIdComparator iic = new ItemIdComparator();
        Item item1 = new Item(1, "aaa");
        Item item2 = new Item(2, "aaa");
        int result = iic.compare(item1, item2);
        assertEquals(1, result);
    }

    @Test
    public void compareMinus1() {
        ItemIdComparator iic = new ItemIdComparator();
        Item item1 = new Item(2, "aaa");
        Item item2 = new Item(1, "aaa");
        int result = iic.compare(item1, item2);
        assertEquals(-1, result);
    }
}