package com.self.shiroframework.business.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.shiroframework.business.IUserBusiness;
import com.self.shiroframework.dao.mapper.UserMapper;
import com.self.shiroframework.entity.User;
import com.self.shiroframework.entity.UserExample;

@Service
public class UserBusinessImpl implements IUserBusiness{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(User record) {
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		return 0;
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		return null;
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return 0;
	}

	@Override
	public User selectByName(String userName) {
		User user = null;
		if (StringUtils.isBlank(userName)){
			return user;
		}
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(userName);
		List<User> userList  = userMapper.selectByExample(example);
		if(null != userList && !userList.isEmpty()) {
			user = userList.get(0);
		}
		return user;
	}

}
