package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@RequestMapping
	public ModelAndView listProcess(){
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataAll();
		
		return new ModelAndView("showMessage", "message", list);
		
	}
}
