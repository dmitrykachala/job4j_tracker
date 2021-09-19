package ru.job4j.collection;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] array1 = o1.split("/");
        String[] array2 = o2.split("/");
        if (!array1[0].equals(array2[0])) {
            return array2[0].compareTo(array1[0]);
        }
        for (int i = 1; i < Math.min(array1.length, array2.length); i++) {
            if (!array1[i].equals(array2[i])) {
                return array1[i].compareTo(array2[i]);
            }
        }
        return Integer.compare(array1.length, array2.length);
    }
}