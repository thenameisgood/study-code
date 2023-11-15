package org.example.structure.bridge;

/**
 * 系统设计期间，如果这个类里面的一些东西，会扩展很多，这个东西就应该分离出来
 *
 * 抽象化角色：定义抽象类，并包含一个对实例化对象的引用
 * 扩展抽象化角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实例化角色中的业务方法
 * 实现化角色：定义实现化角色的接口，供扩展抽象化角色调用
 *
 *
 * 使用场景？
 * 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时
 * 当一个系统不希望使用继承或因多层次继承导致系统类的个数急剧增加时
 * 当一个系统需要在构建的抽象化角色和具体化角色之间增加更多的灵活性时
 * InputStreamReader 桥接模式  从byte stream到character stream的桥
 *
 * 适配器是连接两个类，增强一个类
 * 装饰器是增强一个类
 * */
public class MainTest {
    public static void main(String[] args) {
        ApplePhone applePhone = new ApplePhone();
        applePhone.setSale(new OnlineSale("线上", 100.0f));
        String phone = applePhone.getPhone();
        System.out.println(phone);
    }
}
