package zty.javaweb.springboot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zty.javaweb.springboot.entity.User;
import zty.javaweb.springboot.service.UserService;
/**
 * 测试类
 * @author 周廷宇
 *
 */
@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService us;

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/test")
	@ResponseBody
	public Object test(String name,String pwd){
		User u=new User(name,pwd,null,null);
		us.registe(u);
		return "user: "+name+"finished regiset";
	}
}
