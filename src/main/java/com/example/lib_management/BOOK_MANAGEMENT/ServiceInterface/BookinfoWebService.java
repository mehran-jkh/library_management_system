package com.example.lib_management.BOOK_MANAGEMENT.ServiceInterface;

import com.example.lib_management.BOOK_MANAGEMENT.Models.BookinfoDTO;

import com.example.lib_management.baseUCService.BaseUCService;

public interface BookinfoWebService extends BaseUCService<BookinfoDTO>
{

	public void is_creation_allowed(int id );



}
