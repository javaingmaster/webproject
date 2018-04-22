package zty.javaweb.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import zty.javaweb.springboot.entity.User;
import zty.javaweb.springboot.event.UserRegisterEvent;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private ApplicationContext applicationContext;
	
	public void registe(User u){
		//注册业务逻辑
		//..
		//..

		applicationContext.publishEvent(new UserRegisterEvent(this,u));
	}
}
