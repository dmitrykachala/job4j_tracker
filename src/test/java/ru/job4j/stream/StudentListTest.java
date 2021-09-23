package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class StudentListTest {
    @Test
    public void studentList() {
        Student st1 = new Student(35, "Ivanov");
        Student st2 = new Student(40, "Petrov");
        Student st3 = new Student(85, "Sidorov");
        Student st4 = new Student(35, "Ivanov");
        Student st5 = new Student(40, "Petrov");
        Student st6 = new Student(95, "Pukitman");
        List<Student> listOfStud = List.of(st1, st2, st3, st4, st5, st6);
        StudentList stList = new StudentList();
        Map<String, Student> result = stList.studentList(listOfStud);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", st1);
        expected.put("Petrov", st2);
        expected.put("Sidorov", st3);
        expected.put("Pukitman", st6);
        assertThat(result, is(expected));
    }
}