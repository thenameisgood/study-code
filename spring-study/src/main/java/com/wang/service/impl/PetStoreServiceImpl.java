package com.wang.service.impl;

import com.wang.dao.impl.PetStoreDao;
import com.wang.entity.PetStore;
import com.wang.service.PetStoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PetStoreServiceImpl implements PetStoreService {

    private PetStoreDao petStoreDao;

    public List<String> getUsernameList() {
        List<PetStore> usernameList = petStoreDao.getUsernameList();

        ArrayList<String> names = new ArrayList<>();

        usernameList.forEach(new Consumer<PetStore>() {
            @Override
            public void accept(PetStore petStore) {
                names.add(petStore.getUsername());
            }
        });

        return names;
    }


    public void setPetStoreDao(PetStoreDao petStoreDao) {
        this.petStoreDao = petStoreDao;
    }
}
