package org.example.creation.factory.abstractfactory2;

/**
 * 抽象产品工厂
 *
 * @author: ht
 * @date: 2022/10/15 12:55
 */
public interface IProductFactory {
    //生产手机
    IPhoneProduct productPhone();

    //生产路由器
    IRouterProduct productRouter();
}
