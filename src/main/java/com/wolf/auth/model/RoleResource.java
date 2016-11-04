package com.wolf.auth.model;

import java.util.Date;

/**
 * 角色资源关系表
 * Created by sdyang on 2016/11/4.
 */
public class RoleResource {

    private Long id;//主键

    private Long roleid;//角色主键

    private Long resourceid;//资源主键

    private Date create_time;//创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
