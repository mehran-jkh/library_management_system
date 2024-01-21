package com.example.lib_management.costumValidator.validator;

import com.example.lib_management.AAA.model.PhoneDTO;
import com.example.lib_management.costumValidator.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone , PhoneDTO>
{

	private int country_code_digits;
	private int user_numbers_digits;


	@Override
	public void initialize(Phone phone)
	{
		this.country_code_digits= phone.country_code_digits();
		this.user_numbers_digits= phone.user_numbers_digits();

	}

	@Override
	public boolean isValid(PhoneDTO phoneDTO, ConstraintValidatorContext constraintValidatorContext)
	{
		if (phoneDTO == null )
			return false;


		String country_code= phoneDTO.getCountryCode();
		String user_number=phoneDTO.getUserNumber();

		return country_code != null && country_code.length() == country_code_digits && user_number != null && user_number.length() == user_numbers_digits;
	}
}