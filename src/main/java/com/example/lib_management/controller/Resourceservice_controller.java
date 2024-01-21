package com.example.lib_management.controller;


import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.RESOURCE_MANAGEMENT.Entity.Librarian;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface.LibrarianWebservice;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface.LibraryWebService;
import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibrarianDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("resourcecontroller")
@SessionAttributes("library_id")
public class Resourceservice_controller
{
	private LibraryWebService libraryWebService;
	private LibrarianWebservice librarianWebservice;

	@Autowired
	public Resourceservice_controller(LibraryWebService libraryWebService , LibrarianWebservice librarianWebservice)
	{
		this.libraryWebService = libraryWebService;
		this.librarianWebservice=librarianWebservice;
	}

	/////////////////////////////////////////////////////////////////// view all libraries
	@RequestMapping("viewalllibraries")
	public String libraries_info_page(Model model)
	{
		model.addAttribute("library_list_key", libraryWebService.return_all_models());
		return "view_all_libraries";
	}
	/////////////////////////////////////////////////////////////////// add librarian

//	@RequestMapping("addlibrarian/{code}")
//	public String add_librarian(@PathVariable("code") int code, @ModelAttribute("librarian_key") Librarian librarian , Model model , HttpSession httpSession)
//	{
//
//		// checking the validity of library-code must be done here
//		model.addAttribute("library_id" , code);
//		return "add_librarian";
//	}

//	@RequestMapping("submit_add_librarian")
//	public String add_librarian_submit(@ModelAttribute("librarian_key") LibrarianDTO librarianDTO , Model model , BindingResult bindingResult) throws RepeatedPassword
//	{
//		Integer library_id=(Integer) model.asMap().get("library_id");
//
//		librarianWebservice.add_model(librarianDTO , library_id);
//		return "redirect:/resourcecontroller/viewalllibraries";
//	}

	/////////////////////////////////////////////////////////////////// add librarian













	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public String exception()
	{
		return "constriant violation occured!!!";
	}










}
