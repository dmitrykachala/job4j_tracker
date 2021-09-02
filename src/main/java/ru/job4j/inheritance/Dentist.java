package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean assistantExistance;

    public Dentist(String name, String surname, String education, String birthday, int experience,
                   String specializing, boolean assistantExistance) {
        super(name, surname, education, birthday, experience, specializing);
        this.assistantExistance = assistantExistance;
    }

    public void fillUpTooth() {

    }

}
