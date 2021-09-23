package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.lambda.FunctionalCalculator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address adr1 = new Address("Moscow", "qwert", 1, 3);
        Address adr2 = new Address("Mo", "qw", 10, 30);
        Address adr3 = new Address("Mos", "qwe", 11, 31);
        Address adr4 = new Address("Mosc", "qwer", 12, 32);
        Profile prof1 = new Profile();
        Profile prof2 = new Profile();
        Profile prof3 = new Profile();
        Profile prof4 = new Profile();
        prof1.setAddress(adr1);
        prof2.setAddress(adr2);
        prof3.setAddress(adr3);
        prof4.setAddress(adr4);
        List<Profile> prof = List.of(prof1, prof2, prof3, prof4);
        Profiles pr = new Profiles();
        List<Address> result = pr.collect(prof);
        List<Address> expected = List.of(adr1, adr2, adr3, adr4);
        assertThat(result, is(expected));
    }

    @Test
    public void sort() {
        Address adr1 = new Address("Moscow", "qwert", 1, 3);
        Address adr2 = new Address("Mo", "q", 10, 30);
        Address adr3 = new Address("scow", "e", 11, 31);
        Address adr4 = new Address("Scow", "qwer", 12, 32);
        Address adr5 = new Address("Moscow", "qwert", 1, 3);
        List<Address> source = List.of(adr1, adr2, adr3, adr4, adr5);
        Profiles pr = new Profiles();
        List<Address> result = pr.sort(source);
        List<Address> expected = List.of(adr2, adr1, adr4, adr3);
        assertThat(result, is(expected));
    }
}