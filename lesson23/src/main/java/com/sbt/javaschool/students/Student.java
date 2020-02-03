package com.sbt.javaschool.students;

public class Student {

    private final Long studentId;

    private final String name;
    private final String lastName;

    public Student(Long studentId, String name, String lastName) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
