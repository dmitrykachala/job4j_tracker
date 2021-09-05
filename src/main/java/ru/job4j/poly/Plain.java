package ru.job4j.poly;

public class Plain implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает.");
    }
}
