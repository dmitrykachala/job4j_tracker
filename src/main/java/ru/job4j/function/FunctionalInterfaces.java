package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        int j = 1;
        for (String l : list) {
            biCon.accept(j++, l);
        }

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> (List<String>) map.values();
        List<String> strings = sup.get();

        Consumer<String> con = string -> System.out.println(string);
        Function<String, String> func = string -> string.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}