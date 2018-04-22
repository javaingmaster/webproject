package zty.javaweb.springboot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import zty.javaweb.springboot.entity.User;
import zty.javaweb.springboot.event.UserRegisterEvent;
import zty.javaweb.springboot.service.UserServiceImpl;

@Component
public class UserRegisterListener implements SmartApplicationListener{

	public UserRegisterListener() {
		
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		UserRegisterEvent e=(UserRegisterEvent)event;
		User u=e.getU();
		//System.out.println("注册信息，用户名: "+u.getName()+" 密码: "+u.getPassword());
	}

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> arg0) {
		return arg0==UserRegisterEvent.class;
	}

	@Override
	public boolean supportsSourceType(Class<?> arg0) {
		return arg0==UserServiceImpl.class;
	}

}
