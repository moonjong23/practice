package com.pack.model.product;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends SqlSessionDaoSupport implements ProductDaoInter{
	
	@Autowired
	public ProductDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public List<ProductDto> productlist() throws DataAccessException {
		
		return getSqlSession().selectList("product");
	}
	
	@Override
	public ProductDto detailForm(String no) throws DataAccessException {

		return getSqlSession().selectOne("detailform",no);
	}
	
	
	
}
