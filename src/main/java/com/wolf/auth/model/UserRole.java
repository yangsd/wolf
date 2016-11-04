package com.wolf.auth.model;

import java.util.Date;

/**
 * 用户角色关系表
 * Created by sdyang on 2016/11/4.
 */
public class UserRole {

    private Long id;//主键

    private Long userid;//用户主键

    private Long roleid;//角色主键

    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
