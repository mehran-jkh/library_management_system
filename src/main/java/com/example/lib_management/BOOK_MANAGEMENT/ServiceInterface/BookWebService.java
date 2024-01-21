package com.example.lib_management.BOOK_MANAGEMENT.ServiceInterface;

import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.BOOK_MANAGEMENT.Models.BookDTO;
import com.example.lib_management.baseUCService.BaseUCService;
import com.example.lib_management.common.BaseFilterDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BookWebService  extends BaseUCService <BookDTO>
{

	public String add_model(BookDTO bookDTO, int bookinfo_id, HttpSession httpSession) ;

	public List<BookDTO> return_filtered_models(BaseFilterDTO baseFilterDTO , Integer lib_id );


}
