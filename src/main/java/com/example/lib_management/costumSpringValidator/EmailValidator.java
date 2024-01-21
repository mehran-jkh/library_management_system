package com.example.lib_management.costumSpringValidator;


import com.example.lib_management.AAA.model.UserinfoDTO;
import com.example.lib_management.MEMBER_MANAGEMENT.model.MemberDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass)
	{
		if(UserinfoDTO.class.equals(aClass) || MemberDTO.class.equals(aClass))
			return true;
		return false;
	}

	@Override
	public void validate(Object o, Errors errors)
	{

		ValidationUtils.rejectIfEmptyOrWhitespace(errors , "email" , "email.notempty");
		String email=((UserinfoDTO) o) .getEmail();
		if(!email.endsWith("@gmail.com"))
		{
			errors.rejectValue("email" , "email.invaliddomain");
		}
	}
}
