package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAddAndFindAllAndReplaceAndFindById() {
        HbmTracker hbmStore = new HbmTracker();
        Item item1 = new Item("item 1");
        Item item2 = new Item("item 2");

        hbmStore.add(item1);
        List<Item> all1 = hbmStore.findAll();
        assertEquals(item1, all1.get(0));

        hbmStore.replace(1, item2);
        List<Item> all2 = hbmStore.findAll();
        assertEquals(item2, all2.get(0));

        assertEquals(item2, hbmStore.findById(1));

    }

    @Test
    public void whenFindByNameAndDelete() {
        HbmTracker hbmStore = new HbmTracker();
        Item item1 = new Item("i1");

        hbmStore.add(item1);

        assertEquals(item1, hbmStore.findByName("i1").get(0));

        assertTrue(hbmStore.delete(1));

    }

}