package com.wang.springMybatis.service;

import com.wang.springMybatis.dao.UserDao;
import com.wang.springMybatis.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAll();
    }

    @Override
    public void saveOneUser(User user) {
        userDao.saveOne(user);
    }


//    private PlatformTransactionManager platformTransactionManager;
//
//    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
//        this.platformTransactionManager = platformTransactionManager;
//    }
//    @Override
//    public void saveOneUser(User user) {
//        //创建事务配置对象
//        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
//        //获取事务状态
//        TransactionStatus status = platformTransactionManager.getTransaction(transactionDefinition);
//        try {
//            //处理业务
//            userDao.saveOne(user);
//            //提交
//            platformTransactionManager.commit(status);
//        }catch (Exception e){
//            e.printStackTrace();
//            //回滚
//            platformTransactionManager.rollback(status);
//        }
//    }
}

