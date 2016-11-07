package com.pack.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.pack.model.wish.WishDaoInter;
import com.pack.model.wish.WishDto;

@Controller
public class WishController {

	@Autowired
	private WishDaoInter winter;
	
	@RequestMapping(value="wish.do", method=RequestMethod.GET)
	public ModelAndView wish(HttpSession session){
		String user_id = (String)session.getAttribute("userid");
		List<WishDto> list = winter.wishlist(user_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("wishlist");
		mav.addObject("wlist", list);
		return mav;
	}
	
	@RequestMapping(value="wish_insert.do", method=RequestMethod.GET)
	public String wish_insert(HttpSession session,
			@RequestParam("product_no") String product_no,
			@RequestParam("su") String su){
		//System.out.println(product_no +" " + su);
		String user_id = (String)session.getAttribute("userid");
		boolean b = winter.wish_insert(user_id,product_no,su);
		if(!b){
			return "error";
		}

		return "redirect:/product.do";
	}
	@RequestMapping(value="wish_update.do", method=RequestMethod.GET)
	public String wish_update( HttpSession session, 
			@RequestParam("su") String su,
			@RequestParam("product_no") String product_no){
		
		String user_id = (String)session.getAttribute("userid");
		System.out.println(su+","+product_no);
		winter.wish_update(user_id,su,product_no);
		return "redirect:/wish.do";
	}
	
	@RequestMapping(value="wish_delete.do", method=RequestMethod.GET)
	public String wish_delete(@RequestParam("product_no") String product_no){
		winter.wish_delete(product_no);
		return "redirect:/wish.do";
	}
	
}
