package zty.javaweb.springboot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import zty.javaweb.springboot.entity.User;
import zty.javaweb.springboot.event.UserRegisterEvent;
import zty.javaweb.springboot.service.UserServiceImpl;

@Component
public class UserRegisterSendMailListener implements SmartApplicationListener{


	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		//发邮件业务逻辑
		//..
		//..
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UserRegisterEvent e=(UserRegisterEvent)event;
		User u=e.getU();
		//System.out.println("发送邮件通知: "+u.getName());
	}

	@Override
	public int getOrder() {
		
		return 1;
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
