package com.wang.nio;

public class Parent {
    public static String parent_public_static = "parent_public_static";
    private static String parent_private_static = "parent_private_static";
    protected static String parent_protected_static = "parent_protected_static";
    static String parent_default_static = "parent_default_static";

    public String parent_public = "parent_public";
    private String parent_private = "parent_private";
    protected String parent_protected = "parent_protected";
    String parent_default = "parent_default";

    public Parent() {
        System.out.println("父类的无参构造方法");
    }

    public static void parent_public_static_func() {
    }

    private static void parent_private_static_func() {
    }

    public void parent_public_func() {
    }

    private void parent_private_func() {
        System.out.println("父类的 私有成员方法");
    }

    protected void parent_protected_func() {
    }

    void parent_default_func() {
    }

    public static void main(String[] args) {
        Parent son1 = new Son();
        String pp = son1.parent_private;
        System.out.println(pp);
        son1.parent_private_func();
        // Son son2 = new Son();
        // String sp = son2.parent_private;
        // son2.parent_private_func();
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parent_public='" + parent_public + '\'' +
                ", parent_private='" + parent_private + '\'' +
                ", parent_protected='" + parent_protected + '\'' +
                ", parent_default='" + parent_default + '\'' +
                '}';
    }
}
