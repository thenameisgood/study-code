package org.example.creation.singleton;

public class Person {
    private String name;
    private Integer age;

    //懒汉式
    private volatile static Person instance;
    //饿汉式
    //private final static Person instance = new Person();

    //构造器私有
    private Person() {
    }

    public static Person boss() {
        //懒汉式
        //懒汉式 存在线程并发问题，可能同一时间创建多个person可以给该方法加锁public static synchronized Person boss() {}  但是锁太大，是类锁
/*        if (instance == null) {
            Person person = new Person();
            instance = person;
        }
        return instance;*/
        //可以给代码块加锁  但这样跟在方法加锁没有很大的改变
/*        synchronized (Person.class){
            if (instance == null) {
                Person person = new Person();
                instance = person;
            }
        }
        return instance;*/
        //synchronized放在里面 还是存在问题：好多方法都会进入到if里面，创建多个Person对象
/*        if (instance == null) {
            synchronized (Person.class) {
                Person person = new Person();
                //还是存在多线程问题
                instance = person;
            }
        }
        return instance;*/
        //继续改造   双重检查锁+内存可见性(volatile)
        if (instance == null) {
            synchronized (Person.class) {
                if (instance == null) {
                    Person person = new Person();
                    //还是存在多线程问题
                    instance = person;
                }
            }
        }
        return instance;

        //饿汉式
//        return instance;
    }
}
