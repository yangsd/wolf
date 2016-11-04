package com.wolf.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sdyang on 2016/11/4.
 */
@Mapper
public interface RoleResourceMapper {

    @Select("select rr.id from auth_role r left join auth_role_resource rr on r.id = rr.role_id" +
            " where r.id = #{id} ")
    List<Long> selectIdListByRoleId(@Param("id") Long id);
}
