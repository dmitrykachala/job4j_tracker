package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            if (left.charAt(i) == right.charAt(i)) {
                continue;
            }
            return Character.compare(left.charAt(i), right.charAt(i));
        }
        if (left.length() == right.length()) {
            return 0;
        } else {
            return left.length() > right.length() ? 1 : -1;
        }
    }
}