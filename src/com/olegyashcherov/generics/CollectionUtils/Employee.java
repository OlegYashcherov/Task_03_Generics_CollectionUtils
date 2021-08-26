package com.olegyashcherov.generics.CollectionUtils;

public class Employee extends Person {
    private final int id;

    public Employee(int inn, String name, int id) {
        super(inn, name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" + super.getName() + ", ИНН " + super.getInn() + ", Таб № " + id + "}";
    }
}
