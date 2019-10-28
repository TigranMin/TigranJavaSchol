package com.sbt.javaschool.Lesson_2;

public class Person {
    public static final boolean RESIDENT = true;
    public static final boolean NOT_RESIDENT = false;
    
    private Long id;
    private String firstname;
    private String lasttname;
    private int age;
    private boolean isResident;

    public Person(String firstname, String lasttname) {
        this.firstname = firstname;
        this.lasttname = lasttname;
    }
}
