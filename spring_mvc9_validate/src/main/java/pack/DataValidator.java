package pack;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pack.model.LoginFormBean;

public class DataValidator implements Validator {
	public boolean supports(Class<?> clazz){
		return LoginFormBean.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors){
		//target에 대한 검증지원. 에러 발생시 Errors객체에 저장
		LoginFormBean command= (LoginFormBean)target;
		//입력자료 확인
		System.out.println("datavalidator: " + command.getUserid() + " " + command.getPasswd());
		//입력자료 검증
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Userid", "err.Userid");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Passwd", "err.Passwd"); //  (객체, loginform의 Passwd, properties의 err.Passwd

	}
}