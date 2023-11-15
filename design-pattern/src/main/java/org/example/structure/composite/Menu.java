package org.example.structure.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Menu {
    private Integer id;
    private String name;

    public Menu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //组合模式关注点
    private List<Menu> children = new ArrayList<>();

    void addChildrenMenu(Menu menu) {
        children.add(menu);
    }

    void listMenu() {
        System.out.println(this.id + this.name);
        if (this.children.size() > 0) {
            System.out.println("=============");
            this.children.forEach(new Consumer<Menu>() {
                @Override
                public void accept(Menu menu) {
                    menu.listMenu();
                }
            });
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
