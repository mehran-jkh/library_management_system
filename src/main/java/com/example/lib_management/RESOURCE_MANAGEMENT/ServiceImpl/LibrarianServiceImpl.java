package com.example.lib_management.RESOURCE_MANAGEMENT.ServiceImpl;


import com.example.lib_management.AAA.Entity.Aauser;
import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.BOOK_MANAGEMENT.common.exceptions.BadLibrarianCredetial;
import com.example.lib_management.RESOURCE_MANAGEMENT.Entity.Librarian;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface.LibrarianWebservice;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface.LibraryWebService;
import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibrarianDTO;
import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;

@Service
public class LibrarianServiceImpl extends BaseUCServiceImpl<LibrarianDTO, Librarian> implements LibrarianWebservice
{
	private LibraryWebService libraryWebService;

	public LibrarianServiceImpl()
	{
		super(LibrarianDTO.class, Librarian.class);
	}


	@Autowired
	public LibrarianServiceImpl(LibraryWebService libraryWebService)
	{
		super(LibrarianDTO.class, Librarian.class);
		this.libraryWebService = libraryWebService;
	}

//	@Override
//	public String add_model(LibrarianDTO model, int library_id)
//	{
//
//
////		LibraryDTO libraryDTO=new LibraryDTO();
////		libraryDTO.setId(library_id);
////		model.setLibraryDTO(libraryDTO);
////
////
////		model.setUsername(model.getEmail());
////		model.setPassword(model.getPersonnel_code());
////
////
////		return this.add_model(model);
//	}





	public int return_library_id(HttpSession httpSession)
	{
		Aauser aauser=(Aauser) httpSession.getAttribute("user");
		if(aauser==null)
			throw new BadLibrarianCredetial("there is no logged in librarian. please login as a librarian first");

		int user_id=aauser.getUser_id();

		// finding the librarian with the id of aauser
		Session session=super.sessionFactory.openSession();
		Librarian librarian = (Librarian) session.createNamedQuery("Librarian.FindbyUserid")
				.setParameter("user_id",user_id )
				.getSingleResult();

		if(librarian==null)
			throw new BadLibrarianCredetial("the role of the logged in user is not Librarian. please login as a librarian first");

		// every thing is ok
		// finding librarian's library-id
		int library_id=librarian.getLibrary().getId();

		return library_id;
	}


}
