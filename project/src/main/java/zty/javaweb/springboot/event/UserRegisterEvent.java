package zty.javaweb.springboot.event;

import org.springframework.context.ApplicationEvent;

import zty.javaweb.springboot.entity.User;
/**
 * 测试类
 * @author 周廷宇
 *
 */
public class UserRegisterEvent extends ApplicationEvent{

	
	private static final long serialVersionUID = 1L;
	
	private User u;

	public UserRegisterEvent(Object source,User u) {
		super(source);
		this.u=u;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

}
