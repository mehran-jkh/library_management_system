package com.example.lib_management.AAA.model;


public class PhoneDTO {

	private String CountryCode;
	private String UserNumber;

	public PhoneDTO()
	{
	}

	public PhoneDTO(String countryCode, String userNumber)
	{
		this.CountryCode = countryCode;
		this.UserNumber = userNumber;
	}









	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}

	@Override
	public String toString()
	{
		return CountryCode + "-" + UserNumber ;
	}
}