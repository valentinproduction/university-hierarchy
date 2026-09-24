package com.university;

/** Навчальний предмет (дисципліна). */
public class Subject {
    private final String name;
    private final int credits;
    private Teacher teacher;

    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() { return name; }
    public int getCredits() { return credits; }
    public Teacher getTeacher() { return teacher; }

    void setTeacher(Teacher teacher) { this.teacher = teacher; }

    @Override
    public String toString() {
        return name + " (" + credits + " кредитів)"
                + (teacher != null ? ", викладач: " + teacher.getFullName() : "");
    }
}
