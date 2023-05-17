package ru.job4j.map.attestation;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int count = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                count++;
                score += s.score();
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
/*        return pupils.stream().flatMap(p -> p.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        Collectors.averagingDouble(Subject::score)))
                .entrySet().stream().map(v -> new Label(v.getKey(), v.getValue())).toList();*/
        Map<String, Double> tempMap = new HashMap<>();
        pupils.stream().flatMap(p -> p.subjects().stream())
                .forEach(subj -> {
                    tempMap.merge(subj.name(), (subj.score() / (double) pupils.size()),
                            Double::sum);
                });
        return tempMap.entrySet().stream().map(v -> new Label(v.getKey(), v.getValue())).toList();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil p : pupils) {
            double sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            result.add(new Label(p.name(), sum / p.subjects().size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        for (Pupil p : pupils) {
            double sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            res.add(new Label(p.name(), sum));
        }
        res.sort(Comparator.naturalOrder());
        return res.get(pupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> tempMap = new HashMap<>();
        pupils.stream().flatMap(p -> p.subjects().stream())
                .forEach(subj -> {
                    tempMap.merge(subj.name(), (double) subj.score(), Double::sum);
                });
        return tempMap.entrySet().stream().map(v -> new Label(v.getKey(), v.getValue()))
                .max(Label::compareTo).get();
    }

    private static Map<String, Integer> toTempMap(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                tempMap.merge(s.name(), s.score(), Integer::sum);
            }
        }
        return tempMap;
    }

}
