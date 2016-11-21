package transaction_spring;

import org.springframework.dao.DataAccessException;

public class WowException extends DataAccessException{ // Error 처리용 Class
	
	public WowException(String msg) {
		super("이런 에러가! : " + msg);
}
}
