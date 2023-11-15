package com.wang.createbean;

public class ByInstanceFactory {
    private static DemoBean demoBean = new DemoBean();

    public DemoBean createDemoBeanInstance() {
        return demoBean;
    }
}
