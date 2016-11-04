package com.wolf.auth.mapper;

import com.wolf.auth.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sdyang on 2016/10/29.
 */
@Mapper
public interface UserMapper {

//    @Select("com.wolf.mapper.UserMapper.findAll")
//    List<User> findAll();

    @Select("select * from auth_user")
    public List<User> findAll();

    @Select("select * from auth_user where id=#{id}")
    User findOne(@Param("id") Long id);

    @Insert("")
    public void insert(User user);

    @Update("")
    public void update(User user);

    @Delete("delete from auth_user where id=#{id}")
    public void delete(Long id);

    // 根据用户登录帐号查询用户信息
    @Select("select * from auth_user where loginid=#{loginid}")
    public User findByLoginid(String loginid);
}
