package com.wolf.system.service;


import com.wolf.system.mapper.UserMapper;
import com.wolf.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 用户服务
 * 
 * @author sdyang
 * @date 2016年1月24日 上午10:55:52
 */
@Component
public class UserService {

	//（1）通过xml文件配置查询
//	@Autowired
//	private UserDao userDao;


	//（2）通过注解方式查询
	@Autowired
	private UserMapper userMapper;

	public List<User> findAll() {
		List<User> userList =  (List<User>) userMapper.findAll();
		return userList;
	}

}
