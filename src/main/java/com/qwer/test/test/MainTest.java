package com.qwer.test.test;

import com.qwer.test.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

public class MainTest {
    @Autowired
   static MapperImpl mapperImpl;
    public static void main(String[] args) {

        final User user = new User();
        user.setName("skdj");
        user.setAccountId(33333333);
        mapperImpl.insert(user);
    }
}
