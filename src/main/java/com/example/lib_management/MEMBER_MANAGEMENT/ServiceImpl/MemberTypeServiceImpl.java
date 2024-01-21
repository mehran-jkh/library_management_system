package com.example.lib_management.MEMBER_MANAGEMENT.ServiceImpl;


import com.example.lib_management.MEMBER_MANAGEMENT.Entity.Memeber_Type;
import com.example.lib_management.MEMBER_MANAGEMENT.ServiceInterface.MemberTypeWebService;
import com.example.lib_management.MEMBER_MANAGEMENT.model.MemberTypeDTO;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;

import org.springframework.stereotype.Service;


@Service
public class MemberTypeServiceImpl extends BaseUCServiceImpl<MemberTypeDTO, Memeber_Type> implements MemberTypeWebService
{


	public MemberTypeServiceImpl()
	{
		super(MemberTypeDTO.class, Memeber_Type.class);
	}




}
