package cn.haoxy.interceptor.utils;

import cn.haoxy.interceptor.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Haoxy on 2019-05-29.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Component
public class CacheCollection {

    private static Map<String, User> users;

    static {
        users = new HashMap(100);
        users.put("123", new User("123", "zhangsan", "123456"));
        users.put("456", new User("456", "lisi", "123456"));
    }


    public static User getUser(String id) {
        Iterator<Map.Entry<String, User>> entries = users.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, User> entry = entries.next();
            User user = entry.getValue();
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserByName(String name, String password) {
        Iterator<Map.Entry<String, User>> entries = users.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, User> entry = entries.next();
            User user = entry.getValue();
            if (name.equals(user.getName()) && password.equalsIgnoreCase(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    /**
     * 读取容器总量
     *
     * @return
     */
    public static Integer getSize() {
        return users.size();
    }
}
