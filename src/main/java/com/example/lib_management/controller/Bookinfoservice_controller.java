package com.example.lib_management.controller;


import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.BOOK_MANAGEMENT.Models.BookinfoDTO;
import com.example.lib_management.BOOK_MANAGEMENT.ServiceInterface.BookinfoWebService;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface.LibraryWebService;
import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;
import com.example.lib_management.common.BaseFilterDTO;
import com.example.lib_management.common.SearchFields.book_info_search_fields;
import com.example.lib_management.common.base_search_types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "bookinfocontroller")
public class Bookinfoservice_controller
{

	private BookinfoWebService bookinfoWebService;
	private LibraryWebService libraryWebService;

	@Autowired
	public Bookinfoservice_controller(BookinfoWebService bookinfoWebService ,LibraryWebService libraryWebService )
	{
		this.bookinfoWebService = bookinfoWebService;
		this.libraryWebService = libraryWebService;
	}
///////////////////////////////////////////////////////////////////// FINDS

	@RequestMapping("viewfilteredbooksinfo")
	public String bookinfo_info_page(@ModelAttribute("fileterdto_key") BaseFilterDTO baseFilterDTO,
									 @ModelAttribute("searchfields_key") book_info_search_fields searchValues,
									 @ModelAttribute("searchtypes_key")base_search_types SearchTypes,
									 Model model)
	{
		List<BookinfoDTO> bookinfoDTOList=this.bookinfoWebService.return_filtered_models(baseFilterDTO);
		model.addAttribute("bookinfo_list_key" , bookinfoDTOList);
		return "view_all_bookinfo";
	}




	@RequestMapping("viewlibrariesbybookinfo/{code}")
	public String libraries_with_bookinfo_page(@PathVariable("code") int bookinfo_code , Model model)
	{
		List<LibraryDTO> libraryDTOS=  libraryWebService.return_libraries_with_bookinfo(bookinfo_code);
		model.addAttribute("library_list_key" , libraryDTOS);
		return "view_all_libraries";
	}

///////////////////////////////////////////////////////////////////// ADD

	@RequestMapping(value = "addbookinfo", method = RequestMethod.GET)
	public String add_bookinfo_page(@ModelAttribute("bookinfo_key") BookinfoDTO bookinfoDTO)
	{
		return "add_bookinfo";
	}


	@RequestMapping(value = "submit_add_bookinfo_form",method = RequestMethod.POST)
	public String add_bookinfo_submit(@Valid @ModelAttribute("bookinfo_key") BookinfoDTO bookinfoDTO , BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "add_bookinfo";
		}
		bookinfoWebService.add_model(bookinfoDTO);
		return "redirect:/bookinfocontroller/viewfilteredbooksinfo";
	}











}
