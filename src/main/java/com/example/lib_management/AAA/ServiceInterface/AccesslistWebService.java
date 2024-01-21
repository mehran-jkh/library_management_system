package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.model.AccesslistDTO;
import com.example.lib_management.baseUCService.BaseUCService;

public interface  AccesslistWebService extends BaseUCService<AccesslistDTO>
{

    public int[] load_accessed_pages(int roleid);



}
