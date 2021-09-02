package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int operationNumber;

    public Surgeon() {

    }

    public Surgeon(String name, String surname, String education, String birthday, int experience,
                   String specializing, int operationNumber) {
        super(name, surname, education, birthday, experience, specializing);
        this.operationNumber = operationNumber;
    }

    public void operationDate() {

    }
}
