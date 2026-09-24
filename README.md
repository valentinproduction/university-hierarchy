# University Class Hierarchy (Java)

Ієрархія класів: **Person → Student / Teacher**, а також **Group** та **Subject**.

## UML-діаграма

```mermaid
classDiagram
    direction TB
    class Person {
        <<abstract>>
        -String firstName
        -String lastName
        -LocalDate birthDate
        +getFullName() String
        +getAge() int
        +getRole()* String
    }
    class Student {
        -String recordBookNumber
        -Group group
        -Map~Subject, List~Integer~~ grades
        +addGrade(Subject, int)
        +getAverage() double
        +getAverage(Subject) double
    }
    class Teacher {
        -String department
        -List~Subject~ subjects
        +assignSubject(Subject)
    }
    class Subject {
        -String name
        -int credits
        -Teacher teacher
    }
    class Group {
        -String name
        -Teacher curator
        -List~Student~ students
        -List~Subject~ subjects
        +addStudent(Student)
        +addSubject(Subject)
        +getAverageGrade() double
    }
    Person <|-- Student
    Person <|-- Teacher
    Group "1" o-- "0..*" Student : складається з
    Group "0..*" o-- "0..*" Subject : вивчає
    Group "0..*" --> "1" Teacher : куратор
    Teacher "1" --> "0..*" Subject : викладає
    Student "0..*" --> "0..*" Subject : оцінки
```

## Запуск

```bash
mkdir out
javac -d out src/com/university/*.java
java -cp out com.university.Main
```
