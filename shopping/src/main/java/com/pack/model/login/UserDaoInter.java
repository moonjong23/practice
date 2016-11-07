package com.pack.model.login;

import org.springframework.dao.DataAccessException;

public interface UserDaoInter {
	
	UserDto UserInfo(String userid) throws DataAccessException;
}
