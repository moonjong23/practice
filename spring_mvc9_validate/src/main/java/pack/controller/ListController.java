package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
	
	@RequestMapping("/list")
	public String process(Model model){
		String msg = "로그인 성공으로 비즈니스 로직 수행";
		model.addAttribute("message", msg);
		return "showMessage";
	}
}
