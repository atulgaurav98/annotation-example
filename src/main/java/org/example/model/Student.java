package org.example.model;

@SuppressWarnings("unused")
public class Student {

    private String name;
    private int age;

    // Constructors
    public Student() {
        this.name = "Default Name";
        this.age = 18;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
