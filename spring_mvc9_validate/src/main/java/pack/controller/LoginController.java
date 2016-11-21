package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.DataValidator;
import pack.model.LoginFormBean;

@Controller
public class LoginController {

   @ModelAttribute("command")   //@ModelAttribute는 다른 어노테이션보다 먼저 수행된다.
   public LoginFormBean formBack(){
	   System.out.println("modelAtt");
      return new LoginFormBean();
   }
   
   @RequestMapping(value = "login", method=RequestMethod.GET)
   public String form(){
	   System.out.println("req 1");
      return "loginform"; //view이름
   }
   
   @RequestMapping(value = "login", method=RequestMethod.POST)
   public String submit(@Validated @ModelAttribute("command") LoginFormBean bean,
		   BindingResult result){ //BindingResult : 입력자료 오류 검사 수행

	   System.out.println("submit: " + bean.getUserid() + " " +bean.getPasswd() );
	   if(result.hasErrors()){
		   System.out.println("---- validator count : " + result.getErrorCount() + "개");
	   }
	   if(bean.getUserid().equals("aa") && 
			   bean.getPasswd().equals("11")){
		   int a = 10/2 ;
		   return "redirect:/list"; //목록보기

	   }else{
		   System.out.println("req f");
		   return "loginform"; //입력화면
	   }
   }
   
   @InitBinder
   public void initBinder(WebDataBinder binder){ /*스프링은 @InitBinder 어노테이션이 적용된 메서드를 이용해서 폼과 커맨드 
												   객체 사이의 매핑을 처리해주는 WebDataBinder를 초기화할 수 있도록 하고 있다. 
												   이 메서드에서 WebDataBinder.setValidator() 메서드를 이용해서 커맨드 객체의 
												   유효성 여부를 검사할 때 사용할 Validator를 설정하게 됨*/
	   binder.setValidator(new DataValidator());
   }
}