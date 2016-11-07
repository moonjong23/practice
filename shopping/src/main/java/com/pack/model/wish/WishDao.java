package com.pack.model.wish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class WishDao extends SqlSessionDaoSupport implements WishDaoInter{
	
	@Autowired
	public WishDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public List<WishDto> wishlist(String user_id) throws DataAccessException {
		
		return getSqlSession().selectList("wish",user_id);
	}
	
	@Override
	public boolean wish_insert(String user_id, String product_no, String su) throws DataAccessException {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("user_id", user_id);
			map.put("product_no", product_no);
			map.put("su", su);
			getSqlSession().insert("wish_insert",map);
			return true;
		} catch (Exception e) {
			System.out.println("wish_insert error: " + e);
			return false;
		}
	}
	
	@Override
	public void wish_update(String user_id, String su , String product_no) throws DataAccessException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("product_no", product_no);
		map.put("su", su);
		getSqlSession().update("wish_update", map);
		
	}	
	
	@Override
	public void wish_delete(String product_no) throws DataAccessException {
		getSqlSession().delete("wish_delete", product_no);
		
	}
}
