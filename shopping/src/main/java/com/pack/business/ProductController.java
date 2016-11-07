package com.pack.business;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack.model.product.ProductDaoInter;
import com.pack.model.product.ProductDto;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDaoInter inter;
	
	@RequestMapping(value="product.do", method=RequestMethod.GET)
	public ModelAndView product(HttpSession session){
		List<ProductDto> list = inter.productlist();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("productlist");
		mav.addObject("plist",list);
		return mav;
	}
	
	@RequestMapping(value="detailform.do", method=RequestMethod.GET)
	public ModelAndView detailForm(@RequestParam("no") String no){
		
		ProductDto dto = inter.detailForm(no);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detailForm");
		mav.addObject("dlist", dto);
		return mav;
	}
}
