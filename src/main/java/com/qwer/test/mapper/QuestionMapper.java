package com.qwer.test.mapper;

import com.qwer.test.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (accountId,title,description,gmtCreate,gmtModify,tag) values (#{accountId},#{title},#{description},#{gmtCreate},#{gmtModify},#{tag})")
    void insertAll(Question question);
    @Select("select * from question order by id desc")
    List<Question> findAll();
}
