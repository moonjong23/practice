package com.pack.model.board;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pack.model.login.UserDto;

public interface BoardDaoInter {
	
	int boardCount(String s_Date, String e_Date) throws DataAccessException;
	
	List<BoardDto> getBoardlist(int startRow, int endRow, String s_Date, String e_Date) throws DataAccessException;
	
	String getBoard_maxnum() throws DataAccessException;
	
	boolean insertBoard(String num, String name, String passwd, String title, String content) throws DataAccessException;
	
	boolean deleteBoard(String num) throws DataAccessException;
	



}
