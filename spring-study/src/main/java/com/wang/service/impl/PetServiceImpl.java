package com.wang.service.impl;

import com.wang.dao.PetDao;
import com.wang.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;

public class PetServiceImpl implements PetService {
    // @Autowired不能用于静态字段和静态方法上
    
    // @Autowired
    // private static PetDao petDao;
    //
    // @Autowired
    // public static void staticMethod(PetDao petDao){
    // }
}
