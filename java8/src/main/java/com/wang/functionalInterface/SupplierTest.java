package com.wang.functionalInterface;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello";

        String s = supplier.get();
        System.out.println(s);

        System.out.println("-----------");

        Supplier<Student> supplierStudent = () -> new Student();
        System.out.println(supplierStudent.get());

    }
}


class Student {
    private String name = "zhangsan";
    private Integer age = 20;

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
