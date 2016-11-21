package com.pack.model.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao extends SqlSessionDaoSupport implements BoardDaoInter {

	@Autowired
	public BoardDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public int boardCount(String s_Date, String e_Date) throws DataAccessException {
		int count = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("s_Date", s_Date);
		map.put("e_Date", e_Date);
		try {
			count = getSqlSession().selectOne("count",map);
		} catch (Exception e) {
			System.out.println("count error: " + e);
		}
		return count;
	}

	@Override
	public List<BoardDto> getBoardlist(int startRow1, int endRow1, String s_Date, String e_Date) throws DataAccessException {
		Map<String, String> map = new HashMap<String, String>();
		String startRow = Integer.toString(startRow1);
		String endRow = Integer.toString(endRow1);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("s_Date", s_Date);
		map.put("e_Date", e_Date);
		return getSqlSession().selectList("board", map);
	}
	
	@Override
	public String getBoard_maxnum() throws DataAccessException{
		String maxnum = getSqlSession().selectOne("board_maxnum");
		return maxnum;
		
	}
	
	@Override
	public boolean insertBoard(String num, String name, String passwd, 
			String title, String content) throws DataAccessException {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("num", num);
			map.put("name", name);
			map.put("passwd", passwd);
			map.put("title", title);
			map.put("content", content);
			
			getSqlSession().insert("board_insert", map);
			return true;			
		} catch (Exception e) {
			System.out.println("insertBoardlist error: " + e);
			return false;
		}
	}
	
	@Override
	public boolean deleteBoard(String num) throws DataAccessException {
		try {
			getSqlSession().delete("board_delete", num);
			return true;
		} catch (Exception e) {
			System.out.println("deleteboard error: " + e);
			return false;
		}
	}
}
