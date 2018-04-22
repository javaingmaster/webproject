package zty.javaweb.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import zty.javaweb.springboot.inteceptor.LogHandlerInteceptor;

@Configuration
public class InteceptorRegistor extends WebMvcConfigurationSupport{

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		
		super.addInterceptors(registry);
		
		
		//注册拦截器
		
		//registry.addInterceptor(new LogHandlerInteceptor()).addPathPatterns("/eventtest")
		//.addPathPatterns("/eventtest/*");
	}

}
