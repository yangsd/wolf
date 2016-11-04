package com.wolf.auth.mapper;

import com.wolf.auth.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sdyang on 2016/11/4.
 */
@Mapper
public interface UserRoleMapper {

    @Select("select id,user_id,role_id from auth_user_role where user_id=#{user_id}")
    List<UserRole> selectByUserId(@Param("user_id") Long userId);

    @Select("select role_id from auth_user_role where user_id =#{user_id}")
    List<Long> selectRoleIdListByUserId(@Param("user_id") Long userId);
}
