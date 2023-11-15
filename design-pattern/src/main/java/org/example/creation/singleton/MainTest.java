package org.example.creation.singleton;

/**
 * 单例特点：
 * 某个类只能有一个实例(构造器私有)
 * 必须自行创建这个实例(自己编写实例化逻辑)
 * 必须自行向整个系统提供这个实例(对外提供实例化方法)
 * <p>
 * 单例使用场景：
 * 多线程中的线程池
 * 数据库的连接池
 * 系统环境变量  System.getProperties()  System.getenv()
 * 上下文(ServletContext)
 * ....
 * <p>
 * 常见问题：
 * 系统环境变量？
 * Spring中怎么保持组件单例？
 * ServletContext是什么？是单例吗？怎么保证单例？
 * ApplicationContext是什么》是单例吗？怎么保证？
 * 数据库连接池一般是怎么创建出来的，怎么保证单例？
 */
public class MainTest {
    public static void main(String[] args) {
        Person boss = Person.boss();
        Person boss2 = Person.boss();

        System.out.println(boss == boss2);

        System.out.println(System.getProperties());
        System.out.println(System.getenv());
    }
}
