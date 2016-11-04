package com.wolf.auth.model;

import java.util.Date;

/**
 * 系统资源
 * 
 * @author sdyang
 * @date 2016年2月16日 下午4:34:49
 */
public class Resource {

	private Long id; // 主键

	private String name; // 资源名称

	private ResourceType type = ResourceType.menu; // 资源类型

	private String url; // 资源路径

	private String description;//资源描述

	private String icon;//资源图标

	private Long parent_id;//父节点

	private Boolean status = Boolean.FALSE;//状态

	private Integer seq;//顺序

	private Date create_time;//创建时间

	public static enum ResourceType {
		menu("菜单"), button("按钮"), root("根节点");

		private final String info;

		private ResourceType(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

	/**
	 * 父编号
	 */
	public static Long parentCode = (long) 0;

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

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public boolean isRootNode() {
		return this.id == Resource.parentCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public static Long getParentCode() {
		return parentCode;
	}

	public static void setParentCode(Long parentCode) {
		Resource.parentCode = parentCode;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
