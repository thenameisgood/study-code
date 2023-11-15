package org.example.bridge;

/**
 * @author: ht
 * @date: 2022/10/15 15:42
 */
public class test {
    public static void main(String[] args) {
        Computer computer = new Laptop(new Apple());
        computer.info();

        Computer computer1 = new Desktop(new Lenovo());
        computer1.info();
    }
}

