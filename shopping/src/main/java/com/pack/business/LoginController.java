package com.pack.business;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.pack.model.login.UserDaoInter;
import com.pack.model.login.UserDto;

@Controller
public class LoginController {
	
	@Autowired
	private UserDaoInter inter;
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String LoginForm(){
		return "login";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String SubmitLogin(HttpSession session,
			@RequestParam("userid") String userid,
			@RequestParam("passwd") String passwd){

		UserDto dto = inter.UserInfo(userid);
		if(dto != null){ //아이디검사
			String password = dto.getPasswd();
			if(password.equals(passwd)){ //비밀번호 검사
				session.setAttribute("userid", userid);
				System.out.println(session.getAttribute("userid") + " id check");
			}
		}
		return "redirect:/main.do";
	}
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String LoginOut(HttpSession session){
		session.removeAttribute("userid");
		
		return "redirect:/main.do";
	}
	
}
