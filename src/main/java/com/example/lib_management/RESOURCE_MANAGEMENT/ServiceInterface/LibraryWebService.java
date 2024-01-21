package com.example.lib_management.RESOURCE_MANAGEMENT.ServiceInterface;

import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;
import com.example.lib_management.baseUCService.BaseUCService;

import java.util.List;

public interface LibraryWebService extends BaseUCService<LibraryDTO>
{
	List<LibraryDTO> return_libraries_with_bookinfo(int bookinfo_id);



}
