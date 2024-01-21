package com.example.lib_management.RESOURCE_MANAGEMENT.model;

import com.example.lib_management.AAA.model.PhoneDTO;
import com.example.lib_management.costumValidator.annotation.Phone;

import javax.validation.constraints.Size;

public class LibraryDTO
{
	private int id;

	@Size(min = 3 , max=25)
	private String library_name;

	@Phone(country_code_digits = 3 ,user_numbers_digits = 7)
	private PhoneDTO phone;

	private String postal_address;

	private String city;





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibrary_name() {
		return library_name;
	}

	public void setLibrary_name(String library_name) {
		this.library_name = library_name;
	}

	public PhoneDTO getPhone() {
		return phone;
	}

	public void setPhone(PhoneDTO phone) {
		this.phone = phone;
	}

	public String getPostal_address() {
		return postal_address;
	}

	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
