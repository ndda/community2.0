package com.qwer.test.test;

import com.qwer.test.mapper.UserMapper;
import com.qwer.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/*此为mapper接口实现类*/

/**
 * @author 李国宁
 */
public class MapperImpl {
    @Autowired
    UserMapper userMapper;
    public void insert(User user){
        userMapper.insert(user);
        System.out.println("sql插入执行成功");
    }
}
