package com.university;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    private final String recordBookNumber;
    private Group group;
    private final Map<Subject, List<Integer>> grades = new HashMap<>();

    public Student(String firstName, String lastName, LocalDate birthDate, String recordBookNumber) {
        super(firstName, lastName, birthDate);
        this.recordBookNumber = recordBookNumber;
    }

    public String getRecordBookNumber() { return recordBookNumber; }
    public Group getGroup() { return group; }

    /** Викликається з Group.addStudent(), щоб зв'язок був двосторонній. */
    void setGroup(Group group) { this.group = group; }

    public void addGrade(Subject subject, int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Оцінка має бути в межах 0..100");
        }
        grades.computeIfAbsent(subject, s -> new ArrayList<>()).add(grade);
    }

    public List<Integer> getGrades(Subject subject) {
        return List.copyOf(grades.getOrDefault(subject, List.of()));
    }

    public double getAverage(Subject subject) {
        return grades.getOrDefault(subject, List.of()).stream()
                .mapToInt(Integer::intValue).average().orElse(0);
    }

    public double getAverage() {
        return grades.values().stream().flatMap(List::stream)
                .mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public String getRole() { return "Студент"; }
}
