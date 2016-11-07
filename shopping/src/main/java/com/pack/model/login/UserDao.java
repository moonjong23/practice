package com.pack.model.login;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends SqlSessionDaoSupport implements UserDaoInter{
	
	@Autowired
	public UserDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public UserDto UserInfo(String userid) throws DataAccessException {
		return getSqlSession().selectOne("userinfo", userid);
	}

	
}
