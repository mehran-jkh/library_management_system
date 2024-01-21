package com.example.lib_management.common;

public class BaseFilterDTO
{
	private int search_field_code;
	private int search_type_code;
	private String value;

	public int getSearch_field_code() {
		return search_field_code;
	}

	public void setSearch_field_code(int search_field_code) {
		this.search_field_code = search_field_code;
	}

	public int getSearch_type_code() {
		return search_type_code;
	}

	public void setSearch_type_code(int search_type_code) {
		this.search_type_code = search_type_code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}



}
