package org.example.structure.bridge;

public abstract class AbstractPhone {
    AbstractSale sale;  //分离销售渠道 ，桥接的关注点

    //手机的基本信息
    abstract String getPhone();

    public void setSale(AbstractSale sale) {
        this.sale = sale;
    }
}
