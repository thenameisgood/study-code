package org.example.creation.prototype;

import java.util.HashMap;
import java.util.Map;

public class Mybatis {

    //用户缓存
    private Map<String, User> userCache = new HashMap<>();

    /**
     * 从数据库查询user
     */
    public User getUser(String name) throws CloneNotSupportedException {
        if (!userCache.containsKey(name)) {
            return getFromDatabase(name);
        } else {
            //直接从缓存中拿，原型已经拿到，但是不能直接返回，存在脏缓存问题
            //return userCache.get(name);//(本人)
            User user = userCache.get(name);
            //从这个对象快速得到一个克隆体  即原型模式
            User clone = (User) user.clone();
            return clone;
        }
    }

    private User getFromDatabase(String name) throws CloneNotSupportedException {
        System.out.println("查询数据库");
        User user = new User();
        user.setName(name);
        user.setAge(2);
        userCache.put(name, (User) user.clone());
        return user;
    }
}
