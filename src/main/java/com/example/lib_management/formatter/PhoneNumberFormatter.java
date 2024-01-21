package com.example.lib_management.formatter;

import com.example.lib_management.AAA.model.PhoneDTO;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<PhoneDTO>
{


	@Override
	public PhoneDTO parse(String s, Locale locale) throws ParseException
	{
		PhoneDTO phoneDTO=new PhoneDTO();
		String[] phone_number_array=s.split("-");
		int index=s.indexOf("-");



		if(index==0)
		{
			phoneDTO.setCountryCode("0919");
			phoneDTO.setUserNumber(phone_number_array[0]);
		}
		else if(index>0)
		{
			phoneDTO.setCountryCode(phone_number_array[0]);
			phoneDTO.setUserNumber(phone_number_array[1]);
		}

		return phoneDTO;
	}

	@Override
	public String print(PhoneDTO phoneDTO, Locale locale)
	{
		String phone_number= phoneDTO.getCountryCode() + "-" + phoneDTO.getUserNumber();
		return phone_number;
	}
}
