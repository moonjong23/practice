package com.pack.aspect;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class Advice {
	
	@Around("execution(* board(..)) || execution(* product(..)) || execution(* wish(..))")
	public ModelAndView login(ProceedingJoinPoint joinPoint) throws Throwable{
		ModelAndView mav = new ModelAndView();
		HttpSession session = null;
		
		for(Object o:joinPoint.getArgs()){	
			if (o instanceof HttpSession){
				session = (HttpSession) o;
			}
		}
		if (session.getAttribute("userid") == null || 
				session.getAttribute("userid").equals("userid")) {
			mav.setViewName("login");
		}else{
			mav = (ModelAndView)joinPoint.proceed();			
		}
		return mav;
		
		
	}
	
	
}
