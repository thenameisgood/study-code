package org.example.structure.composite;

public class MainTest {
    public static void main(String[] args) {
        Menu root = new Menu(1, "系统管理");
        Menu 角色管理 = new Menu(2, "角色管理");
        角色管理.addChildrenMenu(new Menu(21,"固定角色"));
        角色管理.addChildrenMenu(new Menu(22,"临时角色"));
        root.addChildrenMenu(角色管理);

        Menu 用户管理 = new Menu(3, "用户管理");
        用户管理.addChildrenMenu(new Menu(31, "垃圾用户"));
        用户管理.addChildrenMenu(new Menu(32, "VIP用户"));
        用户管理.addChildrenMenu(new Menu(33, "普通用户"));
        root.addChildrenMenu(用户管理);

        root.listMenu();
    }
}
