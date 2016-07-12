package com.self.shiroframework.security;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.self.shiroframework.business.IUserBusiness;
import com.self.shiroframework.entity.User;

@Component
public class MdtitRealm extends AuthorizingRealm {
	
	@Autowired
	@Qualifier("userBusinessImpl")
	private IUserBusiness userBusiness;
	
	public MdtitRealm() {
		setName("MdtitRealm");
		setAuthenticationTokenClass(UsernamePasswordToken.class);
	}
	
	// 授权信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		Long userId = (Long)principals.fromRealm(getName()).iterator().next();
//		User user = userDao.getUser(userId);
//		if (user != null) {
//			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			for(Role role : user.getRoles()) {
//                info.addRole(role.getName());
//                info.addStringPermissions(role.getPermissions());
//            }
//            return info;
//		} else {
			return null;
//		}
	}

	// 认证信息
	// 登录时调用
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userBusiness.selectByName(token.getUsername());
		if(user != null){
			return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
		}else{
			return null;
		}
	}
	

}
