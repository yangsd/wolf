package com.wolf.core.model;

import java.util.Date;

/**
 * Created by sdyang on 2016/10/29.
 */
public class SqlConfig {

    private Long id;//主键

    private String key;

    private String value;

    private Long categroy_id;

    private String category_name;

    private String remark;//备注

    private String dialect;//方言

    private String dr;//逻辑删除标识

    private Date create_time;

    private Long client_id;//租户

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getCategroy_id() {
        return categroy_id;
    }

    public void setCategroy_id(Long categroy_id) {
        this.categroy_id = categroy_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
