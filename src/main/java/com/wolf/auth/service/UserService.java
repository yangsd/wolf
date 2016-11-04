package com.wolf.auth.service;


import com.wolf.auth.mapper.RoleMapper;
import com.wolf.auth.mapper.UserMapper;
import com.wolf.auth.mapper.UserRoleMapper;
import com.wolf.auth.model.Role;
import com.wolf.auth.model.User;
import com.wolf.auth.shiro.PasswordHelper;
import com.wolf.auth.vo.UserVo;
import com.wolf.util.RandomKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 用户服务
 * 
 * @author sdyang
 * @date 2016年1月24日 上午10:55:52
 */
@Service
public class UserService {

	@Autowired
	private PasswordHelper helper;

	//（1）通过xml文件配置查询
//	@Autowired
//	private UserDao userDao;


	//（2）通过注解方式查询
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

//	public List<User> findAll() {
//		List<User> userList =  (List<User>) userMapper.findAll();
//		return userList;
//	}

	// 根据登录名查找用户
	public User findUserByLoginid(String loginid) {
		return userMapper.findByLoginid(loginid);
	}

	// 根据登录名查找角色
	public Set<String> findRoles(String loginid) {

		User user = userMapper.findByLoginid(loginid);

		if (user == null) {
			return Collections.emptySet();
		}

		List<Long> roleIds = userRoleMapper.selectRoleIdListByUserId(user.getId());

		if (roleIds == null || roleIds.size()==0) {
			return Collections.emptySet();
		}

		Set<String> roles = new HashSet<String>();

		for (Long roleId : roleIds) {
			Role role = roleMapper.findOne(roleId);
			if (role != null) {
				roles.add(role.getName());
			}
		}
		return roles;
	}

	public Set<String> findPermissions(String loginid) {
		return this.findRoles(loginid);
	}


	/**
	 * 保存用户
	 * @param user
	 * @author sdyang
	 * @date   2016年2月23日 上午11:45:14
	 */
	public void save(User user){
		if(StringUtils.isEmpty(user.getId())){
			helper.encryptPassword(user);
			userMapper.insert(user);
		}else{
			User u = userMapper.findOne(user.getId());
			u.setUsername(user.getUsername());
			u.setEmail(user.getEmail());
			u.setStatus(user.getStatus());

			userMapper.update(user);
		}
	}

	// 修改密码
	public void changePassword(Long userId, String newPassword) {
		User user = userMapper.findOne(userId);
		user.setPassword(newPassword);
		helper.encryptPassword(user);
		userMapper.update(user);
	}

	//重置密码
	public String resetPassword(Long id){
		User user = userMapper.findOne(id);
		String password = RandomKey.getRandomKey();//随机密码
		user.setPassword(password);
		helper.encryptPassword(user);
		userMapper.update(user);
		return password;
	}

	// 用户列表
	public List<UserVo> findAll() {
		List<UserVo> userVoList = new ArrayList<UserVo>();
		List<Role> roles = (List<Role>) roleMapper.findAll();
		Map<Long,Role> roleMap = new HashMap<Long,Role>();
		for(Role r:roles){
			roleMap.put(r.getId(), r);
		}
		List<User> userList =  (List<User>) userMapper.findAll();
		for(User u:userList){
			UserVo vo = new UserVo();
			//-------------------------------------------
			//待完善
			//-------------------------------------------
			userVoList.add(vo);
		}
		return userVoList;
	}

	// 删除用户
	public void delete(Long id) {
		userMapper.delete(id);
	}

	//根据主键查询用户
	public User findOne(Long id){
		return userMapper.findOne(id);
	}

}
