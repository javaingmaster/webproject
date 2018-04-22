package zty.javaweb.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {
	
	//@Pointcut("execution(* zty.javaweb.springboot.service.EventTestService.testZtyEvent(..))")
    //切点..
	
	//@Around("excudeService()")
    //..
}
