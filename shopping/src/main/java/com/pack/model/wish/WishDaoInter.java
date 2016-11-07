package com.pack.model.wish;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface WishDaoInter {
	
	List<WishDto> wishlist(String user_id) throws DataAccessException;
	
	boolean wish_insert(String user_id,String product_no, String su) throws DataAccessException;
	
	void wish_update(String user_id,String su,String product_no) throws DataAccessException;
	
	void wish_delete(String product_no) throws DataAccessException;
}
