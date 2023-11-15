package org.example.structure.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 享元工厂
 */
public class ZuDao {
    public static Map<String, AbstractWaitressFlyweight> pool = new HashMap<>();

    static {
        pool.put(UUID.randomUUID().toString(), new Waitress("1000","张三",10,true));
        pool.put(UUID.randomUUID().toString(), new Waitress("1001","李四",11,true));
        pool.put(UUID.randomUUID().toString(), new Waitress("1002","王五",12,true));
    }

    public static void add(AbstractWaitressFlyweight abstractWaitressFlyweight){
        pool.put(UUID.randomUUID().toString(), abstractWaitressFlyweight);
    }

    public static AbstractWaitressFlyweight get(String id){
        Waitress waitress = (Waitress) pool.get(id);
        if (!waitress.canService){
            return null;
        }
        return waitress;
    }
}
