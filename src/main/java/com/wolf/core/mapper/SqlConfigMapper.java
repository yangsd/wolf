package com.wolf.core.mapper;

import com.wolf.core.model.SqlConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by sdyang on 2016/10/29.
 */
@Mapper
public interface SqlConfigMapper {

    @Select(value = "select * from sys_sql_config where key =#{key} and dialect=#{dialect} and client_id=#{client_id} and dr=0")
    SqlConfig findByKey(@Param("key") String key, @Param("dialect") String dialect, @Param("client_id") String client_id);
}
