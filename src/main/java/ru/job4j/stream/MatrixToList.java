package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.function.*;
import java.util.Map;
import java.util.stream.Stream;

public class MatrixToList {
    public List<Integer> matrixToList(Integer[][] integers) {
        return Stream.of(integers)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
