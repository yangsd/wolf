package com.wolf.auth.service;

import com.wolf.auth.mapper.RoleMapper;
import com.wolf.auth.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 系统角色服务
 * 
 * @author sdyang
 * @date 2016年2月16日 下午5:25:53
 */
@Component
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private ResourceService resourceService;

	public void save(Role role) {
		if(role.getId() == null){
			roleMapper.insert(role);
		}else{
			roleMapper.update(role);
		}
	}

	public void delete(Long roleId) {
		roleMapper.delete(roleId);
	}

	public Role findOne(Long roleId) {
		return roleMapper.findOne(roleId);
	}

	public List<Role> findAll() {
		return (List<Role>) roleMapper.findAll();
	}

	public Set<String> findRoles(Long... roleIds) {
		Set<String> roles = new HashSet<String>();
		for (Long roleId : roleIds) {
			Role role = findOne(roleId);
			if (role != null) {
				roles.add(role.getName());
			}
		}
		return roles;
	}
}
