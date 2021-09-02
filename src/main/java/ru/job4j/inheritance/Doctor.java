package ru.job4j.inheritance;

public class Doctor extends Profession {

    private int experience;
    private String specializing;

    public Doctor() {

    }

    public Doctor(String name, String surname, String education, String birthday, int experience,
                  String specializing) {
        super(name, surname, education, birthday);
        this.experience = experience;
        this.specializing = specializing;
    }

    public String duty(String date) {
        return  date;
    }
}
