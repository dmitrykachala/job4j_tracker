package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.*;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = p -> p.getName().contains(key);
        Predicate<Person> sname = p -> p.getSurname().contains(key);
        Predicate<Person> address = p -> p.getAddress().contains(key);
        Predicate<Person> phone = p -> p.getPhone().contains(key);
        Predicate<Person> combine = name.or(sname).or(address).or(phone);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
