package com.example.lib_management.MEMBER_MANAGEMENT.ServiceImpl;


import com.example.lib_management.MEMBER_MANAGEMENT.Entity.Library_Member;
import com.example.lib_management.MEMBER_MANAGEMENT.Entity.System_Member;
import com.example.lib_management.MEMBER_MANAGEMENT.ServiceInterface.LibraryMemberWebService;
import com.example.lib_management.MEMBER_MANAGEMENT.common.InvalidNationalCode;
import com.example.lib_management.MEMBER_MANAGEMENT.common.RepeatedMembership;
import com.example.lib_management.MEMBER_MANAGEMENT.model.LibraryMemberDTO;

import com.example.lib_management.MEMBER_MANAGEMENT.model.MemberDTO;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceImpl.LibrarianServiceImpl;
import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class LibraryMemberServiceImpl extends BaseUCServiceImpl<LibraryMemberDTO , Library_Member>  implements LibraryMemberWebService
{
	private LibrarianServiceImpl librarianService;



	@Autowired
	public void setLibrarianService(LibrarianServiceImpl librarianService) {
		this.librarianService = librarianService;
	}



	public LibraryMemberServiceImpl()
	{
		super(LibraryMemberDTO.class, Library_Member.class);
	}


	@Override
	public String add_model(LibraryMemberDTO model , HttpSession httpSession)
	{
		Session session=sessionFactory.openSession();

		List<System_Member> system_members = (List<System_Member>) session.createNamedQuery("SystemMember.findbyNationalcode")
				.setParameter("national_code",model.getSystemMember().getNational_code() )
				.getResultList();

		if(system_members.size() <0)
			throw new InvalidNationalCode("there is no memeber with this national code in the system");


		int library_id=librarianService.return_library_id(httpSession);

		List<Library_Member> library_members = (List<Library_Member>) session.createNamedQuery("LibraryMember.findbyNationalcodeAndLibrary")
				.setParameter("national_code",model.getSystemMember().getNational_code()  )
				.setParameter("libid" , library_id)
				.getResultList();

		if(library_members.size()>0)
			throw new  RepeatedMembership("this member has been already added to this library ");
		model.setLibrary(new LibraryDTO());
		model.getLibrary().setId(library_id);


		model.setSystemMember(new MemberDTO());
		model.getSystemMember().setUser_id(system_members.get(0).getUser_id());


		return this.add_model(model);
	}




}
