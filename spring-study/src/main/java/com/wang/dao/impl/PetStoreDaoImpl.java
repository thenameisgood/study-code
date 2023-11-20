package com.wang.dao.impl;

import com.wang.dao.PetStoreDao;
import com.wang.entity.PetStore;

import java.util.ArrayList;
import java.util.List;

public class PetStoreDaoImpl implements PetStoreDao {

    public List<PetStore> getUsernameList(){
        PetStore petStore0 = new PetStore("小王", "宠物1店", "山东泰安");
        PetStore petStore1 = new PetStore("小李", "宠物2店", "山东烟台");
        PetStore petStore2 = new PetStore("小赵", "宠物3店", "浙江杭州");

        ArrayList<PetStore> petStores = new ArrayList<>();
        petStores.add(petStore0);
        petStores.add(petStore1);
        petStores.add(petStore2);
        return petStores;
    }
}
