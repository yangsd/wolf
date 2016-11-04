package com.wolf.auth.mapper;

import com.wolf.auth.model.Resource;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sdyang on 2016/11/3.
 */
@Mapper
public interface ResourceMapper {

    @Select("select id,name,type,url,description,icon,parent_id,status,seq,create_time " +
            "        from auth_resource " +
            "        where type = #{type} " +
            "        and parent_id is null order by seq")
    List<Resource> selectAllByTypeAndPIdNull(@Param("type") Integer type);

    @Select("select id,name,type,url,description,icon,parent_id,status,seq,create_time " +
            "        from auth_resource " +
            "        where type = #{type} " +
            "        and parent_id = #{parent_id} order by seq")
    List<Resource> selectAllByTypeAndPId(@Param("type") Integer resourceType, @Param("parent_id") Long parent_id);

    @Select("select id,name,type,url,description,icon,parent_id,status,seq,create_time from auth_resource ")
    List<Resource> findAll();

    @Select("select * from auth_resource where id=#{id}")
    Resource findOne(@Param("id") Long id);

    @Insert("")
    public void insert(Resource resource);

    @Update("")
    public void update(Resource resource);

    @Delete("delete from auth_resource where id=#{id}")
    public void delete(Long id);
}
