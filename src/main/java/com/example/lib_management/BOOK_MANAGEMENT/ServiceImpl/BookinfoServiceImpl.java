package com.example.lib_management.BOOK_MANAGEMENT.ServiceImpl;


import com.example.lib_management.BOOK_MANAGEMENT.Entity.Book_Information;
import com.example.lib_management.BOOK_MANAGEMENT.Models.BookinfoDTO;
import com.example.lib_management.BOOK_MANAGEMENT.ServiceInterface.BookinfoWebService;
import com.example.lib_management.BOOK_MANAGEMENT.common.exceptions.CreationNotAllowed;
import com.example.lib_management.common.SearchFields.book_info_search_fields;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import com.example.lib_management.common.BaseFilterDTO;
import org.hibernate.Session;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class BookinfoServiceImpl extends BaseUCServiceImpl<BookinfoDTO , Book_Information> implements BookinfoWebService
{


	public BookinfoServiceImpl() throws InstantiationException, IllegalAccessException
	{
		super(BookinfoDTO.class, Book_Information.class);
	}

	@Override
	public void is_creation_allowed(int id )
	{
		Session session=sessionFactory.openSession();
		Book_Information book_information   =(Book_Information) session.createNamedQuery("BookInfo.findbyid")
				.setParameter("id" , id).getSingleResult();
		session.close();

		if(book_information.isIs_creation_allowed()==false)
		{
			throw new CreationNotAllowed("you cannot create a copy of this book");
		}

	}



	@Override
	public List<BookinfoDTO> return_filtered_models(BaseFilterDTO baseFilterDTO)
	{
		book_info_search_fields searchValues=new book_info_search_fields();
		return super.return_filtered_models(baseFilterDTO, book_info_search_fields.searchFields);
	}



}
