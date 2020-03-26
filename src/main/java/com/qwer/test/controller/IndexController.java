package com.qwer.test.controller;

import com.qwer.test.DTO.QuestionDisplayDTO;
import com.qwer.test.cache.CookieCache;
import com.qwer.test.mapper.UserMapper;
import com.qwer.test.service.QuestionDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 李国宁
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CookieCache cookieCache;
    @Autowired
    private QuestionDisplayService questionDisplayService;


    /**以下方法为网站页面主方法；
    *获取cookie，根据token判断用户是否登录并返回不同的操作按钮；
     */
    @GetMapping("/")
    public String returnIndexPage(HttpServletRequest httpServletRequest, Model model){
        try{
            String cookieToken=cookieCache.cache(httpServletRequest,userMapper);
            model.addAttribute("cookieToken",cookieToken);
            List<QuestionDisplayDTO> questionDisplayDTOList=questionDisplayService.questionDisplay();
            model.addAttribute("questionDisplayDTOList",questionDisplayDTOList);
            return "index";
        }catch (Exception e){
            List<QuestionDisplayDTO> questionDisplayDTOList=questionDisplayService.questionDisplay();
            model.addAttribute("questionDisplayDTOList",questionDisplayDTOList);
            return "index";
        }


        /*if(cookieCache.cache(httpServletRequest,userMapper)==1){
            model.addAttribute("cookieToken",cookieToken);

            return "index";
        }else {
            return "index";
        }
*/

        /*final Cookie[] cookies = httpServletRequest.getCookies();
        try {
            for (Cookie cookie:cookies){
                if("token".equals(cookie.getName())){
                    String cookieToken=cookie.getValue();
                    if (userMapper.findToken(cookieToken)!=null){
                        model.addAttribute("cookieToken",cookieToken);
                    }
                    break;
                }
            }
            return "index";
        }catch (Exception e){
            System.out.println("没有cookie");
            return "index";}*/
    }



}
