package org.example.structure.bridge;

public abstract class AbstractSale {
    private String type;
    private Float price;

    public AbstractSale(String type, Float price) {
        this.type = type;
        this.price = price;
    }

    String getSaleInfo(){
        return "销售渠道："+type+"  价格："+price;
    }
}
