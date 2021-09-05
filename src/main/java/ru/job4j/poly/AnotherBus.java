package ru.job4j.poly;

public class AnotherBus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по ДОПам.");
    }
}
