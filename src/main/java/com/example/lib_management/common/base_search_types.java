package com.example.lib_management.common;

import java.util.HashMap;

public class base_search_types {

	public   HashMap<Integer , String> searchTypes;


	public base_search_types()
	{
		searchTypes=new HashMap<Integer ,String>();


		searchTypes.put(0 , "exactly equal");
		searchTypes.put(1 , "contains");
		searchTypes.put(2 , "start with");
		searchTypes.put(3 , "end with");

	}

	public  HashMap<Integer, String> getSearchTypes() {
		return searchTypes;
	}

	public void setSearchTypes(HashMap<Integer, String> searchTypes) {
		this.searchTypes = searchTypes;
	}
}
