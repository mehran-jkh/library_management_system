package com.example.lib_management.AAA.Embedable;

import javax.persistence.Embeddable;

@Embeddable
public class Phone
{
	private String CountryCode;
	private String UserNumber;

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




}
