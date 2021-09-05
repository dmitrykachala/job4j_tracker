package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plain1 = new Plain();
        Vehicle plain2 = new Plain();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus1 = new AnotherBus();
        Vehicle bus2 = new AnotherBus();

        Vehicle[] vehicles = new Vehicle[]{plain1, plain2, train1, train2, bus1, bus2};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
