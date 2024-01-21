package com.example.lib_management.costumValidator.annotation;


import com.example.lib_management.costumValidator.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone
{

	String message() default "{invalid_phone_message}" ; // reading message from resource bundle file...

	int country_code_digits() default 4;
	int user_numbers_digits() default 7;


	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};



}
