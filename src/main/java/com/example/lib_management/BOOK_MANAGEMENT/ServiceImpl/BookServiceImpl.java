package com.example.lib_management.BOOK_MANAGEMENT.ServiceImpl;

import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.BOOK_MANAGEMENT.Entity.Book;
import com.example.lib_management.BOOK_MANAGEMENT.Models.BookDTO;


import com.example.lib_management.BOOK_MANAGEMENT.Models.BookinfoDTO;
import com.example.lib_management.BOOK_MANAGEMENT.ServiceInterface.BookWebService;

import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceImpl.LibrarianServiceImpl;
import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;

import com.example.lib_management.common.BaseFilterDTO;
import com.example.lib_management.common.SearchFields.book_search_fields;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl extends BaseUCServiceImpl<BookDTO, Book> implements BookWebService
{


	private LibrarianServiceImpl librarianService;



	@Autowired
	public void setLibrarianService(LibrarianServiceImpl librarianService) {
		this.librarianService = librarianService;
	}


	public BookServiceImpl() throws InstantiationException, IllegalAccessException
	{
		super(BookDTO.class, Book.class);
	}

	@PostConstruct
	void init()
	{
		System.out.println("Init method called for BookServiceImpl");
		modelmapper_config();
	}


	private void modelmapper_config()
	{
		TypeMap<BookDTO, Book> propertyMapper1 = super.modelMapper.createTypeMap(BookDTO.class, Book.class);
		propertyMapper1.addMapping(BookDTO::getBook_info, Book::setBook_info);


		TypeMap<Book,BookDTO> propertyMapper2 = super.modelMapper.createTypeMap(Book.class, BookDTO.class);
		propertyMapper2.addMapping(Book::getBook_info, BookDTO::setBook_info);

	}


	@Override
	public String add_model(BookDTO bookDTO, int bookinfo_id, HttpSession httpSession)
	{
		int library_id=librarianService.return_library_id(httpSession);
		// checking the activation of library later

		bookDTO.setLibrary(new LibraryDTO());
		bookDTO.getLibrary().setId(library_id);

		bookDTO.setBook_info(new BookinfoDTO());
		bookDTO.getBook_info().setId(bookinfo_id);


		return super.add_model(bookDTO);
	}
	@Override
	public List<BookDTO> return_filtered_models(BaseFilterDTO baseFilterDTO  , Integer lib_id )
	{
		book_search_fields searchFields=new book_search_fields();
		List<BookDTO> bookDTOS=  super.return_filtered_models(baseFilterDTO, searchFields.searchFields);
		if (lib_id ==null || lib_id==-1)
			return bookDTOS;
		List<BookDTO> filtered_list= bookDTOS.stream().filter(e -> e.getLibrary().getId() ==  lib_id.intValue()).collect(Collectors.toList());
		return filtered_list;
	}

}
