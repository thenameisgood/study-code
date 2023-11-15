package org.example.creation.factory.abstractfactory2;

/**
 * @author: ht
 * @date: 2022/10/15 12:57
 */
public class XiaomiFactory implements IProductFactory {
    @Override
    public IPhoneProduct productPhone() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct productRouter() {
        return new XiaomiRouter();
    }
}

