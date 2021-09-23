package ru.job4j.stream;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.function.*;
import java.util.Map;

public class StudentList {
    public Map<String, Student> studentList(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, s -> s,
                        (s1, s2) -> (s1.getScore() > s2.getScore() ? s1 : s2)));
    }
}
