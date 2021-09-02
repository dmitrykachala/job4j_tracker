package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Йода Магистр Джедаевич");
        student.setGroupNumber(666);
        student.setEnterDate(new Date());

        System.out.println(student.getFio() + " " + student.getGroupNumber() + " "
                + student.getEnterDate());
    }
}
