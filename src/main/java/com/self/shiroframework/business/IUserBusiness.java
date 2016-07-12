package com.self.shiroframework.business;

import java.util.List;

import com.self.shiroframework.entity.User;
import com.self.shiroframework.entity.UserExample;

public interface IUserBusiness {
	int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    
    User selectByName(String userName);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
