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
        if(this.spouse != null){
            this.spouse = null;
            spouse.spouse = null;
        }
        return true;
    }

    public boolean marry (Person person) {
        if(this.man != person.man && this.spouse != person){ //method checks gender of persons and if they are not husband and wife
            if(this.spouse != null) this.divorce();    // If one of them has another spouse - execute divorce
            if(person.spouse != null) person.divorce();   // If one of them has another spouse - execute divorce

            person.setSpouse(this);  // tries to marry
            this.setSpouse(person);  // tries to marry
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) {
        Person andrew = new Person(true, "Andrew");
        Person ann = new Person(false, "Ann");
        andrew.marry(ann);
        //andrew.divorce();
        System.out.println(ann.spouse.name); // Ann's spouse is Andrew

    }

}
