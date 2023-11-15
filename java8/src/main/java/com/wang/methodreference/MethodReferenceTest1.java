package com.wang.methodreference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用实际上是个Lambda表达式的一种语法糖
 * 1.类名::静态方法名字
 * 2.引用名(对象名)::实例方法名
 * 3.类名::实例方法名
 * 4.构造方法引用:   类名::new
 */
public class MethodReferenceTest1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "word", "hw");
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);
        System.out.println("-----------");
        // 类名::静态方法名
        Student student1 = new Student("zahngsan", 20);
        Student student2 = new Student("lisi", 21);
        Student student3 = new Student("wantgwu", 10);
        Student student4 = new Student("zhaoliu", 1);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // 1.类名::静态方法名字

        // students.sort(new Comparator<Student>() {
        //     @Override
        //     public int compare(Student o1, Student o2) {
        //         return Student.compareStudentByScore(o1, o2);
        //     }
        // });
        // students.sort((o1, o2) -> Student.compareStudentByScore(o1, o2));
        students.sort(Student::compareStudentByScore);
        students.forEach(System.out::println);

        System.out.println("-------------");
        // 2.引用名(对象名)::实例方法名
        StudentComparator studentComparator = new StudentComparator();
        students.sort(studentComparator::compareStudentByScore);
        students.forEach(System.out::println);

        System.out.println("-------------");
        // 3.类名::实例方法名
        students.sort(Student::compareByScore);

        System.out.println("-------------");
        // 4.构造方法引用:    类名::new
        Student student = new Student();
        System.out.println(student.getString(() -> "sssss"));
        System.out.println(student.getString2("abc", String::new));
    }
}


class Student {
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public static int compareStudentByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public int compareByScore(Student student) {
        return this.getScore() - student.getScore();
    }

    public int compareByName(Student student) {
        return this.getName().compareToIgnoreCase(student.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}