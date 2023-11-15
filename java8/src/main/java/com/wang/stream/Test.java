package com.wang.stream;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("A");
        student.setAge(10);
        System.out.println("student  " + student);

        Student student1 = change(student);
        System.out.println("student  " + student);
        System.out.println("student1 " + student1);

        Integer i = 1;
        System.out.println("i  " + i);
        Integer integer = changeInteger(i);
        System.out.println("i  " + i);
        System.out.println("integer " + integer);
    }

    public static Student change(Student student) {
        student.setName("B");
        student.setAge(20);
        return student;
    }

    public static Integer changeInteger(Integer integer) {
        integer = 100;
        return integer;
    }

}

class Student {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
