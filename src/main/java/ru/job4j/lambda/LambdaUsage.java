package ru.job4j.lambda;

import java.util.*;
import java.util.function.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("descend compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };

        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);

        String[] names1 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp1 = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names1, lengthCmp1);
    }
}
