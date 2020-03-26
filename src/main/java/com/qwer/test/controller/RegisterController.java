package com.qwer.test.controller;

import com.qwer.test.mapper.UserMapper;
import com.qwer.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 李国宁
 */
@Controller
public class RegisterController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/register")
    public String returnRegisterPage() {
        return "register";
    }


    /**
     * 以下方法是由register页面点击注册后跳转所需方法；
     * 获取表单内容，并存储到user数据库中；
     */
    @RequestMapping(value = "/", method = RequestMethod.POST, params = {"name", "accountId", "password"})
    public String userPersistence(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "accountId") int accountId,
            @RequestParam(value = "password") String password,
            HttpServletResponse httpServletResponse
    ) {
        String token = UUID.randomUUID().toString();
        final User user = new User();
        user.setName(name);
        user.setAccountId(accountId);
        user.setPassword(password);
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModify(user.getGmtCreate());
        user.setToken(token);
        user.setAvatarUrl("http://localhost:8887/images/longLegs.jpeg");
        userMapper.insert(user);
        httpServletResponse.addCookie(new Cookie("token", token));

        //在注册成功后需要重新检测下登录状态，所以使用redirect重定向；
        return "redirect:/";
    }
}