package com.wolf.auth.mapper;

import com.wolf.auth.model.Resource;
import com.wolf.auth.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sdyang on 2016/11/3.
 */
@Mapper
public interface RoleMapper {

    @Select("select id,name,description,status,seq,create_time from auth_role")
    List<Role> selectAll();

    @Select("select rr.resource_id from auth_role r left join auth_role_resource rr on r.id=rr.role_id " +
            " where r.id = #{id}")
    List<Long> selectResourceIdListByRoleId(@Param("id") Long id);

    @Select(" select s.id,s.name,s.url,s.description,s.icon,s.parent_id,s.seq,s.status,s.type,s.create_time " +
            " from auth_role r " +
            " left join auth_role_resource e on r.id = e.role_id " +
            " left join auth_resource s on e.resource_id = s.id " +
            " where r.id = #{id}  and s.type = #{type}")
    List<Resource> selectResourceIdListByRoleIdAndType(@Param("id") Long id,@Param("type") int type);

    @Select(" select e.id,s.url from auth_role r " +
            " left join auth_role_resource e on r.id = e.role_id " +
            " left join auth_resource s on e.resource_id = s.id " +
            " where r.id = #{id}")
    List<Map<Long, String>> selectResourceListByRoleId(@Param("id") Long id);


    @Select("select * from auth_role")
    List<Role> findAll();

    @Select("select * from auth_role where id=#{id}")
    Role findOne(@Param("id") Long id);

    @Insert("")
    public void insert(Role role);

    @Update("")
    public void update(Role role);

    @Delete("delete from auth_role where id=#{id}")
    public void delete(Long id);

}
