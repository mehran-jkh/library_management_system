package com.example.lib_management.RESOURCE_MANAGEMENT.Entity;


import com.example.lib_management.costumValidator.annotation.Phone;

import javax.persistence.*;
@NamedQueries
({
		@NamedQuery(name = "Library.findbyId", query = "select e from Library e where (e.id=:library_id)")
})
@Entity
public class Library
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String library_name;

	@Embedded
	private Phone phone;

	private String postal_address;
	private String city;

	private boolean is_active;






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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
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

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
}
