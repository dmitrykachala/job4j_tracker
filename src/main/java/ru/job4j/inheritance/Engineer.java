package ru.job4j.inheritance;

public class Engineer extends Profession {

    private int experience;
    private boolean diploma;

    public Engineer(String name, String surname, String education, String birthday,
                    int experience, boolean diploma) {
        super(name, surname, education, birthday);
        this.experience = experience;
        this.diploma = diploma;
    }

    public void doTheJob(String jobName) {

    }
}
