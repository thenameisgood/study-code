package com.wang.spring.service;

import com.wang.spring.domain.entity.User;

import java.util.*;

public class UserServiceImpl implements UserService {

    //set注入  需要提供set方法

    private String stringMy;
    private Integer integerMy;
    private Double doubleMy;
    private Boolean booleanMy;
    private Date dateMy;

    private String[] arrayMy;
    private List<String> listMy;
    private Set setMy;
    private Map<String,String> mapMy;
    private Properties propertiesMy;

    private OrderService orderService;


    @Override
    public List<User> findUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1001,"小老虎","123456@qq.com"));
        users.add(new User(1002, "长颈鹿", "changjinglu@126.com"));
        users.add(new User(1003, "河马", "hema@163.com"));
        return users;
    }

    public void initMy(){
        System.out.println("我是UserServiceImpl的初始化方法");
    }

    public void destroyMy(){
        System.out.println("我是UserServiceImpl的销毁方法");
    }

    public void setStringMy(String stringMy) {
        this.stringMy = stringMy;
    }

    public void setIntegerMy(Integer integerMy) {
        this.integerMy = integerMy;
    }

    public void setDoubleMy(Double doubleMy) {
        this.doubleMy = doubleMy;
    }

    public void setBooleanMy(Boolean booleanMy) {
        this.booleanMy = booleanMy;
    }

    public void setDateMy(Date dateMy) {
        this.dateMy = dateMy;
    }

    public void setArrayMy(String[] arrayMy) {
        this.arrayMy = arrayMy;
    }

    public void setListMy(List<String> listMy) {
        this.listMy = listMy;
    }

    public void setSetMy(Set setMy) {
        this.setMy = setMy;
    }

    public void setMapMy(Map<String, String> mapMy) {
        this.mapMy = mapMy;
    }

    public void setPropertiesMy(Properties propertiesMy) {
        this.propertiesMy = propertiesMy;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String getStringMy() {
        return stringMy;
    }

    public Integer getIntegerMy() {
        return integerMy;
    }

    public Double getDoubleMy() {
        return doubleMy;
    }

    public Boolean getBooleanMy() {
        return booleanMy;
    }

    public Date getDateMy() {
        return dateMy;
    }

    public String[] getArrayMy() {
        return arrayMy;
    }

    public List<String> getListMy() {
        return listMy;
    }

    public Set getSetMy() {
        return setMy;
    }

    public Map<String, String> getMapMy() {
        return mapMy;
    }

    public Properties getPropertiesMy() {
        return propertiesMy;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}

