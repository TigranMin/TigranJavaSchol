package com.sbt.javaschool.Lesson_2;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @org.junit.jupiter.api.Test
    void divorce() {
        Person person1 = new Person(true, "Barack");
        Person person2 = new Person(false, "Michelle");

        person1.marry(person2);
        person2.divorce();

        assertNull(person1.getSpouse());
    }

    @org.junit.jupiter.api.Test
    void marry() {
        Person person1 = new Person(true, "Barack");
        Person person2 = new Person(false, "Michelle");
        Person person3 = new Person(true, "Donald");
        Person person4 = new Person(false, "Melania");

        person1.marry(person2);
        person3.marry(person4);

        assertEquals(person1.getSpouse(), person2);
        assertEquals(person3.getSpouse(), person4);
    }

    @org.junit.jupiter.api.Test
    void marry_After_Marriage() {
        Person person1 = new Person(true, "Barack");
        Person person2 = new Person(false, "Michelle");
        Person person3 = new Person(true, "Donald");
        Person person4 = new Person(false, "Melania");

        person1.marry(person2);
        person3.marry(person4);
        person1.marry(person4);

        assertNotEquals(person1.getSpouse(), person2);
        assertNotEquals(person3.getSpouse(), person4);
        assertEquals(person4.getSpouse(), person1);
    }

    @org.junit.jupiter.api.Test
    void gay_Marriage_Is_Illegal() {
        Person person1 = new Person(true, "Barack");
        Person person2 = new Person(false, "Michelle");
        Person person3 = new Person(true, "Donald");
        Person person4 = new Person(false, "Melania");

        person1.marry(person3);
        person2.marry(person4);

        assertNull(person1.getSpouse());
        assertNull(person2.getSpouse());
        assertNull(person3.getSpouse());
        assertNull(person4.getSpouse());
    }
}