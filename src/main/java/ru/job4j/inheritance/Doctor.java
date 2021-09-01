package ru.job4j.inheritance;

public class Doctor extends Profession {

    private int experience;
    private String specializing;

    public Doctor() {

    }

    public String duty(String date) {
        return  date;
    }
}
