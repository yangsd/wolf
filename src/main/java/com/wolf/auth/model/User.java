package com.wolf.auth.model;

import java.util.Date;

/**
 * 系统用户
 * 
 * @author sdyang
 * @date 2016年1月23日 下午5:32:11
 */

public class User {

	private Long id;// 主键

	private String loginid;// 登录帐号

	private String password;// 密码

	private String username;// 用户姓名

	private String mobile;//手机号码

	private String weixinid;//微信号

	private String email;// 邮箱

	private String salt; // 加密密码的盐

	private Boolean status = Boolean.FALSE;// 状态：默认启用0

	private Date create_time;

	public User() {
	}

	public User(String loginid, String password) {
		this.loginid = loginid;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
}
