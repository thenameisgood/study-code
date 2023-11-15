package org.example.structure.flyweight;

/**
 * 具体享元类
 * */
public class Waitress extends AbstractWaitressFlyweight {

    //不变属性
    private String id;
    private String name;
    private Integer age;

    public Waitress(String id, String name, Integer age, boolean canService) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.canService = canService;
    }

    @Override
    void service() {
        System.out.println("工号: " + id + " 姓名: " + name + " 年龄: " + age + "正在服务");
        this.canService = false;
    }

    @Override
    void end() {
        System.out.println("工号: " + id + " 姓名: " + name + " 年龄: " + age + "服务完毕");
        this.canService = true;
    }
}
