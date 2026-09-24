package com.university;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Олена", "Коваль", LocalDate.of(1980, 5, 14), "Інформатика");
        Teacher t2 = new Teacher("Андрій", "Мельник", LocalDate.of(1975, 11, 2), "Математика");

        Subject java = new Subject("Програмування на Java", 5);
        Subject math = new Subject("Вища математика", 4);
        t1.assignSubject(java);
        t2.assignSubject(math);

        Group group = new Group("КН-21", t1);
        group.addSubject(java);
        group.addSubject(math);

        Student s1 = new Student("Іван", "Петренко", LocalDate.of(2004, 3, 21), "KN2101");
        Student s2 = new Student("Марія", "Шевченко", LocalDate.of(2004, 8, 9), "KN2102");
        group.addStudent(s1);
        group.addStudent(s2);

        s1.addGrade(java, 95);
        s1.addGrade(math, 82);
        s2.addGrade(java, 88);
        s2.addGrade(math, 91);

        System.out.println(group + ", куратор: " + group.getCurator().getFullName());
        group.getSubjects().forEach(s -> System.out.println("  - " + s));
        for (Student s : group.getStudents()) {
            System.out.printf("%s | серед. бал: %.1f%n", s, s.getAverage());
        }
        System.out.printf("Середній бал групи: %.1f%n", group.getAverageGrade());
    }
}
