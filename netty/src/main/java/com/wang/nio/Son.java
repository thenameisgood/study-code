package com.wang.nio;

public class Son extends Parent {
    public String son_public = "son_public";
    private String son_private = "son_private";
    protected String son_protected = "son_protected";
    String son_default = "son_default";

    public Son() {
        System.out.println("子类的无参构造方法");
    }

    public static void son_public_static_func() {
    }

    private static void son_private_static_func() {
    }

    public void son_public_func() {
    }

    private void son_private_func() {
    }

    protected void son_protected_func() {
    }

    void son_default_func() {
    }

    @Override
    public String toString() {
        return "Son{" +
                "son_public='" + son_public + '\'' +
                ", son_private='" + son_private + '\'' +
                ", son_protected='" + son_protected + '\'' +
                ", son_default='" + son_default + '\'' +
                '}';
    }
}
