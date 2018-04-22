package zty.javaweb.springboot.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * @author 周廷宇
 * 异步方法配置
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer{

	private static final Logger logger = LoggerFactory.getLogger(AsyncConfig.class);
	
	public AsyncConfig() {
		
	}

	@Override
	public Executor getAsyncExecutor() {
		
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {	
		return new MyAsyncExceptionHandler();
	}

	 class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {	  

		@Override
		public void handleUncaughtException(Throwable t, Method m, Object... obj) {
			 logger.error("Exception occurs in async method", t.getMessage());	 
		}		
	 }
}
