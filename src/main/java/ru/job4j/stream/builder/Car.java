package ru.job4j.stream.builder;

import java.util.Objects;

public class Car {
    private String brand;

    private String model;

    private String engineType;

    private String typeOfDrive;

    private String transmissionType;

    private String colour;

    private int doorCount;

    private boolean swLocation;

    static class Builder {
        private String brand;
        private String model;
        private String engineType;
        private String typeOfDrive;
        private String transmissionType;
        private String colour;
        private int doorCount;
        private boolean swLocation;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        Builder buildTypeOfDrive(String typeOfDrive) {
            this.typeOfDrive = typeOfDrive;
            return this;
        }

        Builder buildTransmissionType(String transmissionType) {
            this.transmissionType = transmissionType;
            return this;
        }

        Builder buildColour(String colour) {
            this.colour = colour;
            return this;
        }

        Builder buildDoorCount(int doorCount) {
            this.doorCount = doorCount;
            return this;
        }

        Builder buildSWLocation(boolean swLocation) {
            this.swLocation = swLocation;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.engineType = engineType;
            car.typeOfDrive = typeOfDrive;
            car.transmissionType = transmissionType;
            car.colour = colour;
            car.doorCount = doorCount;
            car.swLocation = swLocation;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("Nissan")
                .buildModel("Note e-Power")
                .buildEngineType("hybrid")
                .buildTypeOfDrive("FWD")
                .buildTransmissionType("reducer")
                .buildColour("burgundy")
                .buildDoorCount(5)
                .buildSWLocation(false)
                .build();
        System.out.println(car);
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", engineType='" + engineType + '\''
                + ", typeOfDrive='" + typeOfDrive + '\''
                + ", transmissionType='" + transmissionType + '\''
                + ", colour='" + colour + '\''
                + ", doorCount=" + doorCount
                + ", swLocation=" + swLocation
                + '}';
    }
}
