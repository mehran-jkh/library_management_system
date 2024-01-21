package com.example.lib_management.common.SearchFields;

import java.util.HashMap;

public class book_info_search_fields

{
	public  static   HashMap<Integer , String> searchFields;

	public book_info_search_fields()
	{
		///////////////////////////////////////////////////////////////////
		searchFields =new HashMap<Integer , String>();

		searchFields.put(0,"title");
		searchFields.put(1 ,"author");
		searchFields.put(2 ,"isbn");
		searchFields.put(3 ,"all");
		///////////////////////////////////////////////////////////////////
	}

	public HashMap<Integer, String> getSearchFields() {
		return searchFields;
	}

	public void setSearchFields(HashMap<Integer, String> searchFields) {
		this.searchFields = searchFields;
	}

}
