package com.wolf.auth.model;

import java.util.Date;

/**
 * 系统角色
 * 
 * @author sdyang
 * @date 2016年1月23日 下午5:37:58
 */
public class Role {

	private Long id; // 主键

	private String name; // 角色标识 程序中判断使用,如"admin"

	private String description; // 角色描述

	private Boolean status = Boolean.FALSE; // 是否可用

	private Integer seq;

	private Date create_time;

	public Role() {
	}

	public Role(String name, String description, Boolean available) {
		this.name = name;
		this.description = description;
		this.status = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
