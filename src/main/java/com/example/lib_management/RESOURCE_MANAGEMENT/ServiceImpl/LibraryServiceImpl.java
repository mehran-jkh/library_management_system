package com.example.lib_management.RESOURCE_MANAGEMENT.ServiceImpl;


import com.example.lib_management.RESOURCE_MANAGEMENT.Entity.Library;
import com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface.LibraryWebService;
import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LibraryServiceImpl extends BaseUCServiceImpl<LibraryDTO, Library> implements LibraryWebService
{
	public LibraryServiceImpl()
	{
		super(LibraryDTO.class, Library.class);

	}


	@Override
	public List<LibraryDTO> return_libraries_with_bookinfo(int bookinfo_id)
	{
		Session session=sessionFactory.openSession();

		List<Library> libraryList =session.createNamedQuery("Library.findbybookinfo")
				.setParameter("bookinfo_id", bookinfo_id)
				.getResultList();


		List<LibraryDTO> modelList=new ArrayList<>();
		for (Library entity:libraryList)
		{
			modelList.add(modelMapper.map(entity , LibraryDTO.class));
		}
		return modelList;
	}




}
