package com.example.lib_management.MEMBER_MANAGEMENT.ServiceInterface;

import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.MEMBER_MANAGEMENT.model.LibraryMemberDTO;
import com.example.lib_management.baseUCService.BaseUCService;

import javax.servlet.http.HttpSession;

public interface LibraryMemberWebService extends BaseUCService<LibraryMemberDTO>
{
	public String add_model(LibraryMemberDTO model , HttpSession session) throws RepeatedPassword;



}
