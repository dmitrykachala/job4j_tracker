package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean chiefOrNot;

    public Builder(String name, String surname, String education, String birthday, int experience,
                   boolean diploma, boolean chiefOrNot)  {
        super(name, surname, education, birthday, experience, diploma);
        this.chiefOrNot = chiefOrNot;
    }

    public void whereBuild() {

    }

}
