package com.qwer.test.service;

import com.qwer.test.DTO.QuestionDisplayDTO;
import com.qwer.test.mapper.QuestionMapper;
import com.qwer.test.mapper.UserMapper;
import com.qwer.test.model.Question;
import com.qwer.test.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 李国宁
 * 调用userMapper和questionMapper将user和question数据合并一块
 * 作为index页面问题展示部分的业务逻辑
 * 将所有question数据放入questionList集合里面
 * 迭代questionList，并根据accountId插入user数据
 */
@Service
public class QuestionDisplayService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    public List questionDisplay(){
        List questionDisplayList=new ArrayList();
        List<Question> questionList=questionMapper.findAll();
        for(Question question:questionList){
            User user=userMapper.findAllbyAccountId(question.getAccountId());
            QuestionDisplayDTO questionDisplayDTO=new QuestionDisplayDTO();
            BeanUtils.copyProperties(question,questionDisplayDTO);
            questionDisplayDTO.setGmtModify(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(question.getGmtModify()));
            questionDisplayDTO.setUser(user);
            questionDisplayList.add(questionDisplayDTO);
        }
        return questionDisplayList;
    }
}
