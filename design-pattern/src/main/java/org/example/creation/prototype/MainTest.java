package org.example.creation.prototype;

/**
 * 原型模式，用于创建重复的对象，同时又能保证性能
 * <p>
 * 使用场景：
 * 资源优化，节省开销
 * 性能和安全要求
 * 一个对象多个修改者的场景
 * 一个对象需要提供给其他对象访问，而且各个调用者可能需要修改其值时可以考虑使用原型模式拷贝多个对象供调用者使用
 * 深拷贝(递归克隆)、浅拷贝(只是属性赋值)
 * ...
 */
public class MainTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mybatis mybatis = new Mybatis();
        //直接在缓存中获取，是十分危险的，因为缓存中的数据可能已经不是最新的了
        //脏缓存问题
        for (int i = 0; i < 10; i++) {
            //按理说，100次里面拿到的都应该是 小老虎，但是在第6次的时候，有人把user的name改了，导致后面的人拿到的是改变后的长颈鹿，而不是小老虎
            User user = mybatis.getUser("小老虎");
            if (i == 5) {
                user.setName("长颈鹿");
            }
            System.out.println(user);
        }
    }
}
