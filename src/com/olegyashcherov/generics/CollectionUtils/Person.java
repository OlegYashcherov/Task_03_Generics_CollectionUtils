package com.olegyashcherov.generics.CollectionUtils;

public class Person implements Comparable<Person> {
    private final int inn;
    private final String name;

    public Person(int inn, String name) {
        this.inn = inn;
        this.name = name;
    }

    public int getInn() {
        return inn;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + name + ", ИНН " + inn + "}";
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }
}
