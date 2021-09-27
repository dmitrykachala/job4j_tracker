package ru.job4j.stream;

import java.util.Comparator;
import ru.job4j.stream.Tuple;

public class ScoreComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple t1, Tuple t2) {
        return Integer.compare((int) t1.getScore(), (int) t2.getScore());
    }
}

