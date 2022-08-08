package ru.job4j.map.attestation;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        return pupils.stream().map(Pupil::subjects)
                .flatMap(Collection::stream)
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    public static List<Label> averageScoreBySubject/*Pupil*/(List<Pupil> pupils) {
        return pupils.stream().flatMap(p -> p.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        LinkedHashMap::new, Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Label(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static List<Label> averageScoreByPupil/*Subject*/(List<Pupil> pupils) {
        return pupils.stream().map(p -> new Label(p.name(),
                        p.subjects().stream()
                                .mapToInt(Subject::score)
                                .average()
                                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static Label bestStudent(List<Pupil> pupils) {
        long counter = pupils.size();
        return pupils.stream().map(p -> new Label(p.name(),
                p.subjects().stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .sorted(Comparator.naturalOrder())
                .skip(counter - 1)
                .findFirst().get();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return pupils.stream().flatMap(p -> p.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        LinkedHashMap::new, Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Label(s.getKey(), s.getValue()))
                .max(Comparator.comparingDouble(Label::score)).orElse(null);
    }

}
