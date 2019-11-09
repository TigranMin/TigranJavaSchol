package lesson2;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PersonTest {

    @Test
    public void divorce() {
        Person person1 = new Person(true, "Barack");
        Person person2 = new Person(false, "Michelle");

        person1.marry(person2);
        person2.divorce();

        assertNull(person1.getSpouse());
        assertNull(person2.getSpouse());
    }

    @Test
    public void marry() {
        Person person1 = new Person(true, "Barack");
        Person person2 = new Person(false, "Michelle");
        Person person3 = new Person(true, "Donald");
        Person person4 = new Person(false, "Melania");

        person1.marry(person2);
        person3.marry(person4);

        assertEquals(person1.getSpouse(), person2);
        assertEquals(person3.getSpouse(), person4);
    }

    @Test
    public void marryAfterMarriage() {
        Person person1 = new Person(true, "Barack");
        Person person2 = new Person(false, "Michelle");
        Person person3 = new Person(true, "Donald");
        Person person4 = new Person(false, "Melania");

        person1.marry(person2);
        person3.marry(person4);
        person1.marry(person4);

        Assert.assertNotSame(person1.getSpouse(), person2);
        Assert.assertNotSame(person3.getSpouse(), person4);
        assertEquals(person4.getSpouse(), person1);
    }

    @Test
    public void gayMarriageIsIllegal() {
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