package ru.job4j.stream;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.function.*;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> sort(List<Address> addresses) {
        return addresses.stream()
                .distinct()
                .sorted(new CityComparator())
                .collect(Collectors.toList());
    }

    class CityComparator implements Comparator<Address> {
        @Override
        public int compare(Address a1, Address a2) {
            return a1.getCity().compareTo(a2.getCity());
        }
    }
}
