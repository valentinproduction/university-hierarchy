package com.university;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private final String department;
    private final List<Subject> subjects = new ArrayList<>();

    public Teacher(String firstName, String lastName, LocalDate birthDate, String department) {
        super(firstName, lastName, birthDate);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public List<Subject> getSubjects() { return List.copyOf(subjects); }

    /** Призначає предмет викладачу (двосторонній зв'язок). */
    public void assignSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
            subject.setTeacher(this);
        }
    }

    @Override
    public String getRole() { return "Викладач"; }
}
