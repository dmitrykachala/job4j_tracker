package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dart@mall.sw", "Dart Mall");
        map.put("luk@sky.sw", "Luke Skywalker");
        map.put("master@yoda.sw", "Master Yoda");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
