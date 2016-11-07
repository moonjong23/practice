package com.pack.business;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack.model.board.BoardDaoInter;
import com.pack.model.board.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDaoInter inter;
	
	private int pageSize = 4;

	@RequestMapping(value="board.do",method=RequestMethod.GET)
	public ModelAndView board(HttpSession session,
			@RequestParam(value="pagenum", defaultValue="1") String pagenum){
		int currentPage = Integer.parseInt(pagenum);
		int startRow = (currentPage - 1) * pageSize +1;
		int endRow = pageSize -1;
		int totalCount = inter.boardCount();
		int totalPage = totalCount / pageSize;
		if(totalCount % pageSize > 0) totalPage++;
		List<BoardDto> list = inter.getBoardlist(startRow, endRow);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardlist");
		mav.addObject("blist",list);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("total", totalCount);
		mav.addObject("totalPage",totalPage);
		
		return mav;
		
	}
	@RequestMapping(value="b_insertform.do",method=RequestMethod.GET)
	public String board_insertform(){
		System.out.println("board_insertform");
		return "b_insertform";
	}
	
	@RequestMapping(value="b_insert.do", method=RequestMethod.POST)
	public String board_insert(
			@RequestParam("name") String name,@RequestParam("passwd") String passwd,
			@RequestParam("title") String title,@RequestParam("content") String content){
		
		String maxnum = inter.getBoard_maxnum();
		boolean b = inter.insertBoard(maxnum ,name, passwd, title, content);
		if(b){
			return "redirect:/board.do";			
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value="b_delete.do")
	public String board_delete(@RequestParam("num") String num){
		boolean b = inter.deleteBoard(num);
		if(b){
			return "redirect:/board.do";			
		}else{
			return "error";
		}
	}
}
