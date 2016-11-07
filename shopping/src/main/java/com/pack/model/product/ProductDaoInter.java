package com.pack.model.product;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ProductDaoInter {
	
	List<ProductDto> productlist() throws DataAccessException;
	
	ProductDto detailForm(String no) throws DataAccessException;
}
