package com.qwer.test.cache;

import com.qwer.test.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Component
public class CookieCache {
    public String cache(HttpServletRequest httpServletRequest,UserMapper userMapper){
        final Cookie[] cookies = httpServletRequest.getCookies();
            for (Cookie cookie:cookies){
                if("token".equals(cookie.getName())){
                    String cookieToken=cookie.getValue();
                    if (userMapper.findToken(cookieToken)!=null){
                        return cookieToken;
                    }
                    break;
                }
            }
            return null;
    }
}
