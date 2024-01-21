package com.example.lib_management.controller;



import com.example.lib_management.AAA.commons.exceptions.InvalidCredential;
import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.BOOK_MANAGEMENT.common.exceptions.BadLibrarianCredetial;
import com.example.lib_management.MEMBER_MANAGEMENT.ServiceInterface.LibraryMemberWebService;
import com.example.lib_management.MEMBER_MANAGEMENT.ServiceInterface.MemberTypeWebService;
import com.example.lib_management.MEMBER_MANAGEMENT.ServiceInterface.MemberWebService;
import com.example.lib_management.MEMBER_MANAGEMENT.common.RepeatedMembership;
import com.example.lib_management.MEMBER_MANAGEMENT.common.RepeatedNationalCode;
import com.example.lib_management.MEMBER_MANAGEMENT.model.LibraryMemberDTO;
import com.example.lib_management.MEMBER_MANAGEMENT.model.MemberDTO;
import com.example.lib_management.costumSpringValidator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "membercontroller" )
//@SessionAttributes("membertypes_list_key")
public class Memberservice_controller
{
	private MemberWebService memberWebService;
	private MemberTypeWebService memberTypeWebService;
	private LibraryMemberWebService libraryMemberWebService;


	@Autowired
	public Memberservice_controller(MemberWebService memberWebService , MemberTypeWebService memberTypeWebService , LibraryMemberWebService libraryMemberWebService)
	{
		this.memberWebService=memberWebService;
		this.memberTypeWebService=memberTypeWebService;
		this.libraryMemberWebService=libraryMemberWebService;
	}

	/////////////////////////////////////////////////////////////////// view all


	/////////////////////////////////////////////////////////////////// ADD

	@RequestMapping(value = "addmember", method = RequestMethod.GET)
	public String add_member_page(@ModelAttribute("Member_key") MemberDTO memberDTO , Model model)
	{
		model.addAttribute("membertypes_list_key",memberTypeWebService.return_all_models());

		return "add_member";
	}


	@RequestMapping(value = "submit_add_member_form",method = RequestMethod.POST)
	public String add_member_submit(@ModelAttribute("Member_key") @Valid MemberDTO memberDTO , BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "add_member";
		}

		try
		{
			memberWebService.add_model(memberDTO);
		}
		catch (RepeatedPassword repeatedPassword)
		{
			bindingResult.rejectValue("password" , "password.repeated" , "the password is already used");
			return "add_member";
		}
		catch (RepeatedNationalCode repeatedNationalCode)
		{
			bindingResult.rejectValue("national_code" , "national_code.repeated" , "the national code is already used");
			return "add_member";
		}

		return "redirect:/";
	}


	@RequestMapping(value = "addlibrarymember")
	public String add_library_member(@ModelAttribute("librarymember_key") LibraryMemberDTO libraryMemberDTO)
	{
		return "add_librarymember";
	}

	@RequestMapping(value = "submit_add_library_member_form")
	public String add_library_member_submit( @ModelAttribute("librarymember_key")LibraryMemberDTO libraryMemberDTO , BindingResult bindingResult ,Model model, HttpSession session)
	{
		try
		{
			libraryMemberWebService.add_model(libraryMemberDTO, session);
		}
		catch (BadLibrarianCredetial badLibrarianCredetial)
		{
			bindingResult.addError(new ObjectError("invalid librarian credential" ,badLibrarianCredetial.getMessage()));
			model.addAttribute("errors", bindingResult.getGlobalErrors());
			return "error";
		}
		catch (InvalidCredential invalidCredential)
		{
			bindingResult.rejectValue("systemMember.national_code" , "nationalcode.invalid" , invalidCredential.getMessage());
			return "add_librarymember";
		}
		catch (RepeatedMembership repeatedMembership)
		{
			bindingResult.addError(new ObjectError("repeated membership request" ,repeatedMembership.getMessage()));
			model.addAttribute("errors", bindingResult.getGlobalErrors());
			return "error";
		}
		return "redirect:/";
	}


//	@InitBinder
//	public void initBinder(WebDataBinder binder)
//	{
//		EmailValidator emailValidator=new EmailValidator();
//		binder.addValidators(emailValidator);
//	}





}
