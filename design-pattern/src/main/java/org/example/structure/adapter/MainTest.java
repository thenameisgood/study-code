package org.example.structure.adapter;

/**
 * 适配器模式：将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作
 * 适配器模式分为：类结构型模式(继承)
 *              对象结构型模式(组合)
 *
 * 主要角色：目标(Target)接口：可以是抽象类或接口
 *         适配者(Adaptee)类：隐藏的转换接口
 *         适配器(Adapter)类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口
 *
 * 使用场景？
 * 1.Tomcat如何将Request流转换为标准Request
 * tomcat.Request <==CoyoteAdapte==> servlet.Request
 * 2.SpringAOP中的AdvisorAdapter 增强适配器
 * 前置、后置、环绕通知、返回、结束
 * 3.SpringMVC中经典的HandlerAdapter
 * controller中的方法怎么调用到servlet中的方法(Servlet.doGET() doPost())
 * 4.SpringBoot中WebMvcConfigurationAdapter为什么存在，后面又取消
 *
 */
public class MainTest {
    public static void main(String[] args) {
        MoivePlayer moivePlayer = new MoivePlayer();
        moivePlayer.play();
    }
}
