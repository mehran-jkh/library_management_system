package com.example.lib_management.controller;


import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.BOOK_MANAGEMENT.Models.BookDTO;

import com.example.lib_management.BOOK_MANAGEMENT.ServiceInterface.BookWebService;
import com.example.lib_management.BOOK_MANAGEMENT.ServiceInterface.BookinfoWebService;
import com.example.lib_management.BOOK_MANAGEMENT.common.exceptions.BadLibrarianCredetial;
import com.example.lib_management.BOOK_MANAGEMENT.common.exceptions.CreationNotAllowed;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface.LibraryWebService;
import com.example.lib_management.common.BaseFilterDTO;
import com.example.lib_management.common.SearchFields.book_search_fields;
import com.example.lib_management.common.base_search_types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("bookcontroller")
@SessionAttributes("bookinfo_id")
public class Bookservice_controller
{

	private BookWebService bookWebService;
	private BookinfoWebService bookinfoWebService;
	private LibraryWebService libraryWebService;

	@Autowired
	public Bookservice_controller(BookWebService bookWebService ,BookinfoWebService bookinfoWebService , LibraryWebService libraryWebService )
	{
		this.bookWebService = bookWebService;
		this.bookinfoWebService = bookinfoWebService;
		this.libraryWebService = libraryWebService ;

	}


	///////////////////////////////////////////////////////////////////// ADD

	@RequestMapping(value = "addbook/{code}", method = RequestMethod.GET)
	public String add_book_page(@ModelAttribute("book_key") BookDTO bookDTO , BindingResult bindingResult, Model model , @PathVariable int code , HttpSession httpSession)
	{

		try {
			bookinfoWebService.is_creation_allowed(code);
		}
		catch (CreationNotAllowed creationNotAllowed)
		{
			bindingResult.addError(new ObjectError("creation not allowed" ,creationNotAllowed.getMessage()));
			model.addAttribute("errors", bindingResult.getGlobalErrors());
			return "error";
		}

		model.addAttribute("bookinfo_id" , code);
		bookDTO.setBook_info(bookinfoWebService.return_model_by_id(code));
		return "add_book";
	}

	@RequestMapping(value = "submit_add_book_form",method = RequestMethod.POST)
	public String add_book_submit(BookDTO bookDTO  , Model model , HttpSession httpSession ,BindingResult bindingResult) throws RepeatedPassword
	{

		Integer bookinfo_id=(Integer) model.asMap().get("bookinfo_id");
		try
		{
		bookWebService.add_model(bookDTO , bookinfo_id , httpSession);
		}
		catch (BadLibrarianCredetial badLibrarianCredetial)
		{
			bindingResult.addError(new ObjectError("invalid librarian credential" ,badLibrarianCredetial.getMessage()));
			model.addAttribute("errors", bindingResult.getGlobalErrors());
			return "error";
		}
		return "redirect:/bookcontroller/viewfilterebooks";
	}

	///////////////////////////////////////////////////////////////////// RETRIVE
	@RequestMapping(value = "viewallbooks", method = RequestMethod.GET)
	public String books_info_page( Model model  )
	{
		model.addAttribute("books_list_key" , bookWebService.return_all_models());
		return "view_all_books";
	}

	@RequestMapping("viewfilterebooks" )
	public String view_filterd_books(@ModelAttribute("fileterdto_key") BaseFilterDTO baseFilterDTO ,
									 @ModelAttribute("searchfields_key") book_search_fields searchValues ,
									 @ModelAttribute("searchtypes_key") base_search_types SearchTypes ,
									 Integer library_code ,
									 Model model
	)
	{


		model.addAttribute("libraries_key" , libraryWebService.return_all_models());
		List<BookDTO> bookoDTOList=this.bookWebService.return_filtered_models(baseFilterDTO , library_code);
		model.addAttribute("books_list_key" , bookoDTOList );
		return "view_all_books" ;
	}

	///////////////////////////////////////////////////////////////////// FILTER





}
