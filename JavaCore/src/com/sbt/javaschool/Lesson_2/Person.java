package com.sbt.javaschool.Lesson_2;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public boolean divorce() {
        if(this.spouse != null)
            this.spouse = null;
        return true;
    }

    public boolean marry (Person person) {
        if(this.man != person.man && this.spouse != person){
            this.spouse = person;
            person.setSpouse(this.spouse);
            return true;
        }
        else
            return false;
    }

}
