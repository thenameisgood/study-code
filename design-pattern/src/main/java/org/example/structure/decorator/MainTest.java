package org.example.structure.decorator;

/**
 * 装饰器：装饰器是增强了一个类，只关心“增强”
 * 适配器：适配器侧重连接两个类
 *
 *
 * 装饰器使用场景？
 * 已存在的类，某一天在使用的时候发现功能不够，可以使用装饰器
 * SpringSession中如何进行session与redis关联？HttpRequestWrapper
 *      原来session，也就是HttpSession.getAttribute，数据存在内存
 *      如果想把这个session存入到redis，使用装饰器：Wrapper(session){
 *          getAttribute(String param){
 *              从redis中获取session
 *          }
 *      }
 * MybatisPlus提取了QueryWrapper,这是什么？
 * Spring中BeanWrapper是做什么
 * Spring Webflux中的WebHandlerDecorator？
 * */
public class MainTest {
    public static void main(String[] args) {
        //被装饰对象
        StarTicTok starTicTok = new WangTicTok();
        starTicTok.tictok();
        System.out.println("=======================");
        MeiyanDecorator decorator = new MeiyanDecorator(starTicTok);
        decorator.tictok();
    }
}
