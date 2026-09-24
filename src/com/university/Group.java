package com.university;

import java.util.ArrayList;
import java.util.List;

/** Навчальна група: має куратора, студентів та перелік предметів. */
public class Group {
    private final String name;
    private Teacher curator;
    private final List<Student> students = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();

    public Group(String name, Teacher curator) {
        this.name = name;
        this.curator = curator;
    }

    public String getName() { return name; }
    public Teacher getCurator() { return curator; }
    public void setCurator(Teacher curator) { this.curator = curator; }
    public List<Student> getStudents() { return List.copyOf(students); }
    public List<Subject> getSubjects() { return List.copyOf(subjects); }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.setGroup(this);
        }
    }

    public void addSubject(Subject subject) {
        if (!subjects.contains(subject)) subjects.add(subject);
    }

    public double getAverageGrade() {
        return students.stream().mapToDouble(Student::getAverage).average().orElse(0);
    }

    @Override
    public String toString() {
        return "Група " + name + " (студентів: " + students.size() + ")";
    }
}
