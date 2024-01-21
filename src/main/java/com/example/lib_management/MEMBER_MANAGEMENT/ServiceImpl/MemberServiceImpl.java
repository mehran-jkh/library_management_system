package com.example.lib_management.MEMBER_MANAGEMENT.ServiceImpl;




import com.example.lib_management.AAA.ServiceImpl.UserServiceImpl;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;

import com.example.lib_management.MEMBER_MANAGEMENT.Entity.System_Member;
import com.example.lib_management.MEMBER_MANAGEMENT.ServiceInterface.MemberWebService;
import com.example.lib_management.MEMBER_MANAGEMENT.common.RepeatedNationalCode;
import com.example.lib_management.MEMBER_MANAGEMENT.model.MemberDTO;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import com.example.lib_management.common.jpaOP;
import org.hibernate.Session;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MemberServiceImpl extends BaseUCServiceImpl<MemberDTO , System_Member> implements MemberWebService
{

	public MemberServiceImpl()
	{
		super(MemberDTO.class, System_Member.class);

	}
	private UserServiceImpl userServiceimpl;

	@Autowired
	public void setUserWebService(UserServiceImpl userWebService) {
		this.userServiceimpl = userWebService;
	}

	@Override
	public String add_model(MemberDTO memberDTO) throws RepeatedPassword {
		Session session=sessionFactory.openSession();

		// checking uniqueness of username
		if(!userServiceimpl.check_uniqueness_of_password(memberDTO.getPassword()))
		{
			throw new RepeatedPassword("this password has been already used. please use another password");
		}

		// checking uniqueness of national code
		if (!check_uniqueness_of_national_code(memberDTO.getNational_code()))
		{
			throw new RepeatedNationalCode("this national code has been already used. ");
		}

		// setting role of the member...
		memberDTO.setRoleinfodto(new RoleinfoDTO());
	  	memberDTO.getRoleinfodto().setId(5);

		return super.add_model(memberDTO);

	}


	public boolean check_uniqueness_of_national_code(String national_code)
	{
		Session session=sessionFactory.openSession();
		List<System_Member> list = super.FindbyField("national_code" , jpaOP.Eq , national_code);
		if(list.size()>0)
		{
			return false;
		}
		return true;
	}

	@PostConstruct
	void init()
	{
		System.out.println("Init method called for MemberServiceImpl");
		modelmapper_config();
	}

	public void modelmapper_config()
	{
		TypeMap<System_Member,MemberDTO > propertyMapper1 = super.modelMapper.createTypeMap(System_Member.class, MemberDTO.class);
		propertyMapper1.addMapping(System_Member::getAarole, MemberDTO::setRoleinfodto);

		TypeMap<MemberDTO,System_Member > propertyMapper2 = super.modelMapper.createTypeMap(MemberDTO.class, System_Member.class);
		propertyMapper2.addMapping(MemberDTO::getRoleinfodto, System_Member::setAarole);

	}


}
