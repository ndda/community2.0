package com.qwer.test.controller;

import com.qwer.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李国宁
 */
@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;


    @GetMapping("/login")
    public String returnLoginPage(){
        return "login";
    }


    @RequestMapping(value = "/",method = RequestMethod.POST,params = {"accountId","password"})
    public String loginCache(@RequestParam(value = "accountId") int accountId,
                        @RequestParam(value = "password") String password,
                        Model model,
                        HttpServletResponse httpServletResponse){
        //判断accountId和password是否存在，有一个不存在就返回错误
        //都存在，取出token并传递给浏览器
        String token= userMapper.findTokenByLogin(accountId,password);
        if(token!=null){
            httpServletResponse.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else{
            model.addAttribute("loginError","账号或密码不正确");
            return "login";
        }
    }
}
