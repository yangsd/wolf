package com.wolf.system.dao;

import com.wolf.system.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * 
 * @author sdyang
 * @date 2016年1月23日 下午5:42:27
 */
@Component
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public List<User> findAll(){
		return this.sqlSession.selectList("selectAllUser");
	}

}
