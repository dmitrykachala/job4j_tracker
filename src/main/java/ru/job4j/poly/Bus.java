package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Woohoo! I can move!");
    }

    @Override
    public void passengers(int number) {
        System.out.println("I eat " + number + " humans");
    }

    @Override
    public double refuel(double liters) {
        double fuelPrice = 50.79;
        return (liters * fuelPrice);
    }
}
