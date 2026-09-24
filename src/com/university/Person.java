package com.university;

import java.time.LocalDate;
import java.time.Period;

/** Базовий абстрактний клас для всіх людей в університеті. */
public abstract class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    protected Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }

    public String getFullName() { return lastName + " " + firstName; }

    public int getAge() { return Period.between(birthDate, LocalDate.now()).getYears(); }

    /** Роль людини в університеті (Студент, Викладач ...). */
    public abstract String getRole();

    @Override
    public String toString() { return getRole() + ": " + getFullName() + " (" + getAge() + " р.)"; }
}
