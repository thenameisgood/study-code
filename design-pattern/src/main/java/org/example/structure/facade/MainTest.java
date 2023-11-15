package org.example.structure.facade;

/**
 * 外观模式，又叫门面模式，是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问
 * */
public class MainTest {
    public static void main(String[] args) {
        GovernmentFacade governmentFacade = new GovernmentFacade();
        governmentFacade.handleAll("王");
    }
}
