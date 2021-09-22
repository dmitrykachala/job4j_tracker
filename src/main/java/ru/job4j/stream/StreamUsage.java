package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(-3);
        integers.add(0);
        integers.add(10);
        integers.add(-9);
        integers.add(-1);
        integers.add(31);
        List<Integer> positive = integers.stream().filter(
                p -> p > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
