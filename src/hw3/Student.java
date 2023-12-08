package hw3;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private transient int GPA;

    public Student() {
    }

    public Student(String name, int age, int GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGPA() {
        return GPA;
    }

}
