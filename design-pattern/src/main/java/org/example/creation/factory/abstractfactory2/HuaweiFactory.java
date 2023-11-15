package org.example.creation.factory.abstractfactory2;

/**
 * @author: ht
 * @date: 2022/10/15 12:58
 */
public class HuaweiFactory implements IProductFactory {
    @Override
    public IPhoneProduct productPhone() {
        return new HuaweiPhone();
    }

    @Override
    public IRouterProduct productRouter() {
        return new HuaweiRouter();
    }
}

