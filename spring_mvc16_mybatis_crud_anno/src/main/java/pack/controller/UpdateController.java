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
public class UpdateController {
	
	
	@Autowired
	private MemDaoInter inter;
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView insertForm(@RequestParam("num") String num){
		MemDto dto = inter.selectPart(num);
		return new ModelAndView("upform","dto",dto);
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String insert(MemBean bean){
		boolean b = inter.updateData(bean);
		if(b){
			return "redirect:list";
		}else{
			return "redirect:/error.jsp";
		}
	}
}
