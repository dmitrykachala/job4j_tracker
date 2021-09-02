package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String mainCodeLanguage;

    public Programmer()  {

    }

    public Programmer(String name, String surname, String education, String birthday,
                      int experience, boolean diploma, String mainCodeLanguage)  {
        super(name, surname, education, birthday, experience, diploma);
        this.mainCodeLanguage = mainCodeLanguage;
    }

    public void speedOfCoding() {

    }
}
