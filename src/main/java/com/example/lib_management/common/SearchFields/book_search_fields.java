package com.example.lib_management.common.SearchFields;

import java.util.HashMap;

public class book_search_fields
{


	public  static HashMap<Integer , String> searchFields;



	public book_search_fields()
	{
		searchFields =new HashMap<Integer , String>();

		searchFields.put(0,"book_info.title");
		searchFields.put(1 ,"book_info.author");
		searchFields.put(2 ,"book_info.isbn");
		searchFields.put(3 ,"book_info.all");

	}



	public  HashMap<Integer, String> getSearchFields() {
		return searchFields;
	}

	public  void setSearchFields(HashMap<Integer, String> searchFields) {
		book_search_fields.searchFields = searchFields;
	}
}
