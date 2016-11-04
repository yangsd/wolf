package com.wolf.auth.service;

import com.wolf.auth.mapper.*;
import com.wolf.auth.model.Resource;
import com.wolf.auth.model.Role;
import com.wolf.auth.model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 
 * 
 * @author sdyang
 * @date 2016年2月16日 下午5:24:55
 */
@Component
public class ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleResourceMapper roleResourceMapper;

	public void save(Resource resource) {
		if(resource.getId() == null){
			resourceMapper.insert(resource);
		}else{
			resourceMapper.update(resource);
		}
	}

	public void delete(Long id) {
		resourceMapper.delete(id);
	}

	public Resource findOne(Long id) {
		return resourceMapper.findOne(id);
	}

	public List<Resource> findAll() {
		return (List<Resource>) resourceMapper.findAll();
	}

	

	/**
	 * 
	 * @return
	 * @author sdyang
	 * @date 2016年2月22日 上午9:05:11
	 */
	/*
	public String getResourceTree() {
		String resourceTree;
		Resource result = null;
		List<Resource> resourceList = (List<Resource>) resourceDao.findAll();
		Map<Long, List<Resource>> resourceMap = new HashMap<Long, List<Resource>>();
		List<Resource> childResource = null;
		for (Resource r : resourceList) {			
			if (resourceMap.containsKey(r.getParentId())) {
				childResource = resourceMap.get(r.getParentId());
			}else{
				childResource = new ArrayList<Resource>();
			}
			childResource.add(r);
			resourceMap.put(r.getParentId(), childResource);
		}
		for (Resource r : resourceList) {	
			r.setChildren(resourceMap.get(r.getParentId()));				
		}	
		
		for (Resource r : resourceList) {
			if(r.isRootNode()){
				result = r;
			}
		}
		resourceTree = JSON.toJSONString(result);
		
		return resourceTree;
	}
*/

	// public List<Resource> findMenus(Set<String> permissions) {
	// List<Resource> allResources = findAll();
	// List<Resource> menus = new ArrayList<Resource>();
	// for (Resource resource : allResources) {
	// if (resource.isRootNode()) {
	// continue;
	// }
	// if (resource.getType() != Resource.ResourceType.menu) {
	// continue;
	// }
	// if (!hasPermission(permissions, resource)) {
	// continue;
	// }
	// menus.add(resource);
	// }
	// return menus;
	// }

	public List<Resource> findMenu(List<Long> resourceIds) {
		List<Resource> resources = new ArrayList<Resource>();
		for (Long resourceId : resourceIds) {
			Resource resource = findOne(resourceId);
			if (resource != null
					&& resource.getType() == Resource.ResourceType.menu) {
				resources.add(resource);
			}
		}
		return resources;
	}


	public String getMenuByRole() throws Exception {

		StringBuffer menu = new StringBuffer();

		String loginid = (String) SecurityUtils.getSubject().getPrincipals()
				.getPrimaryPrincipal();// 当前用户登录id

		User user = userMapper.findByLoginid(loginid);// 当前用户

		List<Long> roleIds = userRoleMapper.selectRoleIdListByUserId(user.getId());

		if (roleIds == null || roleIds.size()==0) {
			throw new Exception("用户没有分配角色！");
		}

		//查询用户所拥有的资源

		List<Resource> urls = null;
		List<Long> resourceids = new ArrayList<Long>();
		List<Long> roleids = userRoleMapper.selectRoleIdListByUserId(user.getId());
		for(Long id:roleids) {
			resourceids.addAll(roleMapper.selectResourceIdListByRoleId(id));
		}

		urls = findMenu(resourceids);

		if (urls == null || urls.size() == 0) {
			return null;
		}

		Map<Long, List<Resource>> urlMap = new HashMap<Long, List<Resource>>();
		for (Resource url : urls) {
			// 如果Map里已经包含了key，则增加url
			if (urlMap.containsKey(url.getParent_id())) {
				List<Resource> l = urlMap.get(url.getParent_id());
				l.add(url);
				urlMap.put(url.getParent_id(), l);
			} else {
				// 否则新增一个list,新增一个key
				List<Resource> l = new ArrayList<Resource>();
				l.add(url);
				urlMap.put(url.getParent_id(), l);
			}
		}

		menu.append("<div class=\"easyui-accordion\" id=\"treeMenu\" data-options=\"fit:true,border:false\">");

		// key为0为所有的父菜单
		List<Resource> parentUrl = urlMap.get(Resource.parentCode);
		if (parentUrl != null && parentUrl.size() > 0) {
			for (Resource p : parentUrl) {
				menu.append("<div title=\"" + p.getName()
						+ "\" style=\"padding:10px;\">");
				menu.append("<ul class=\"easyui-tree\">");
				if (urlMap.containsKey(p.getId())) {
					// 子菜单
					this.getSubMenu(p.getId(), urlMap, menu);
				}
				menu.append("</ul>");
				menu.append("</div>");
			}
		}
		menu.append("</div>");
		return menu.toString();
	}

	/**
	 * 组织子菜单
	 * 
	 * @param pk_url
	 * @param urlMap
	 * @param menu
	 * @author sdyang
	 * @date 2015年8月15日 下午12:15:08
	 */
	private void getSubMenu(Long pk_url, Map<Long, List<Resource>> urlMap,
			StringBuffer menu) {

		List<Resource> urlList = urlMap.get(pk_url);
		for (Resource url : urlList) {
			if (urlMap.containsKey(url.getId())) {
				getSubMenu(url.getId(), urlMap, menu);
			} else {
				if (url.getUrl() != null) {
					menu.append("<li>");
					menu.append("<span>");
					menu.append("<a href=\"#\" onclick=\"addTab('"
							+ url.getName()
							+ "','"
							+ url.getUrl()
							+ "')\" data-options=\"plain:true\" class=\"easyui-linkbutton\" >"
							+ url.getName() + "</a>");

					menu.append("</span>");
					menu.append("</li>");
				}
			}
		}
	}
}
