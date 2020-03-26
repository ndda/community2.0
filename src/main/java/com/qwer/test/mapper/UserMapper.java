package com.qwer.test.mapper;

import com.qwer.test.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 李国宁
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,accountId,password,gmtCreate,gmtModify,token,avatarUrl) values(#{name},#{accountId},#{password},#{gmtCreate},#{gmtModify},#{token},#{avatarUrl})")
    void insert(User user);
    @Select("select * from user where token=#{cookieToken}")
    User findToken(String cookieToken);
    @Select("select token from user where accountId=#{accountId} and password=#{password}")
    String findTokenByLogin(int accountId,String password);
    @Select("select accountId from user where token=#{token}")
    int selectAccountId(String token);
    @Select("select * from user where accountId=#{accountId}")
    User findAllbyAccountId(int accountId);
}
