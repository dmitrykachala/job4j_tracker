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
        List<Label> result = new ArrayList<>();
        LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {

                tempMap.computeIfPresent(s.name(), (name, sc) -> sc = sc + s.score());
                tempMap.putIfAbsent(s.name(), s.score());
                }
            }
        tempMap.forEach((name, sc) -> result.add(new Label(name, sc / pupils.size())));
        return result;
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
        List<Label> list = new ArrayList<>();
        LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {

                tempMap.computeIfPresent(s.name(), (name, sc) -> sc = sc + s.score());
                tempMap.putIfAbsent(s.name(), s.score());
            }
        }
        tempMap.forEach((name, sc) -> list.add(new Label(name, sc)));
        list.sort(Comparator.naturalOrder());
        return list.get(pupils.size() - 1);
    }

}
