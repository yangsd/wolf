package com.wolf.system.mapper;

import com.wolf.system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sdyang on 2016/10/29.
 */
@Mapper
public interface UserMapper {

    @Select("com.wolf.mapper.UserMapper.findAll")
    List<User> findAll();
}
