package com.qwer.test.controller;

import com.qwer.test.cache.CookieCache;
import com.qwer.test.mapper.QuestionMapper;
import com.qwer.test.mapper.TagStringToInt;
import com.qwer.test.mapper.UserMapper;
import com.qwer.test.model.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李国宁
 */
@Controller
public class PublishController {
    @Autowired
    private CookieCache cookieCache;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private TagStringToInt tagStringToInt;


    @GetMapping("/publish")
    public String returnPublishPage(HttpServletRequest httpServletRequest, Model model) {
        try {
            if (cookieCache==null){
                return "index";
            }
            String cookieToken = cookieCache.cache(httpServletRequest, userMapper);
            model.addAttribute("cookieToken", cookieToken);
            return "publish";
        } catch (Exception e) {
            return "index";
        }
    }


    @PostMapping("/publish")
    public String questionPersistence(
            @RequestParam(value ="title") String title,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "tag") String tag,
            @RequestParam(value = "token") String token,
            Model model
    ){
        int accountId=userMapper.selectAccountId(token);
        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModify(question.getGmtCreate());
        question.setTag(tagStringToInt.stringToInt(tag));
        question.setAccountId(accountId);
        questionMapper.insertAll(question);
        return "redirect:/";
    }
}
