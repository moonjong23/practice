package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemDaoInter;
import pack.model.MemDto;

@Controller
public class DeleteController {
	@Autowired
	private MemDaoInter inter;
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam("num") String num){
		boolean b = inter.deleteData(num);
		if(b){
			return "redirect:list";
		}else{
			return "redirect:error.jsp";
		}
	}
}
