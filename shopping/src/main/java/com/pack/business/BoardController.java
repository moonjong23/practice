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

	@RequestMapping(value="board.do",method=RequestMethod.GET)
	public ModelAndView board(HttpSession session,
			@RequestParam(value="pagenum", defaultValue="1") String pagenum
			,@RequestParam(value="pagesize",defaultValue="10") int pagesize
			,@RequestParam(value="blocksize",defaultValue="10") int blocksize
			,@RequestParam(value="sDate",defaultValue="2010-01-01" ) String s_Date
			,@RequestParam(value="eDate",defaultValue="2017-01-01" ) String e_Date
			){
	
		int pageSize = pagesize; //페이지당 보여질 레코드 수
		int blockSize = blocksize; // 블록당 보여줄 페이지 수
		
		int currentPage = Integer.parseInt(pagenum); //현재 페이지 번호
		
		//query limit : startRow번 부터 endRow번째 레코드까지 출력 
		int	startRow = ((currentPage - 1) * pageSize); //시작 레코드 번호
		int endRow = pageSize; //레코드 출력 제한 번호(mariaDb)
		int totalCount = inter.boardCount(s_Date,e_Date); //전체 레코드 수
		//전체 페이지 수, 자투리 레코드 처리를 위해 전체 페이지 수를 1개 증가
		int totalPage = (totalCount/pageSize) + ((totalCount % pageSize)>0? 1:0); 
		
		/*블룩처리*/
		int currentBlock = (currentPage / blockSize) //현재 블룩 번호 
						+ ((currentPage % blockSize)>0? 1:0);

		int endBlockPage = currentBlock * blockSize; // 현재 블룩의 끝 페이지 번호
		int startBlockPage = endBlockPage - (blockSize -1); //현재 블록의 시작 페이지 번호
		int totalBlock = (totalPage/blockSize) //최대 블록 수
				+ ((totalPage % blockSize)>0? 1:0); 
		// 끝 페이지 번호가 전체 페이지 수보다 클 때 레코드가 없는 빈 페이지 생성을 막기 위한 처리.
		if(totalPage < endBlockPage) endBlockPage = totalPage;
		List<BoardDto> list = inter.getBoardlist(startRow, endRow, s_Date, e_Date);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardlist");
		mav.addObject("blist",list);
		mav.addObject("currentPage", currentPage); //현재 페이지
		mav.addObject("pageSize", pageSize); //페이지당 레코드 출력 수
		mav.addObject("totalCount", totalCount); //전체 레코드 수
		mav.addObject("totalPage",totalPage); //전체 페이지 수
		mav.addObject("currentBlock", currentBlock); //전체 블록 수
		mav.addObject("blockSize", blockSize); //한 블록당 페이지 출력 수
		mav.addObject("totalBlock", totalBlock); //전체 블록 수
		mav.addObject("startBlockPage",startBlockPage); //블록당 시작 페이지 수
		mav.addObject("endBlockPage", endBlockPage); //블록당 마지막 페이지 수
		mav.addObject("s_Date",s_Date); //검색 년도 범위
		mav.addObject("e_Date",e_Date);

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
