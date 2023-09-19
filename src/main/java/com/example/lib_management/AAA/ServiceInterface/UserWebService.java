package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.Entity.Aauser;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.UserinfoDTO;
import com.example.lib_management.baseService.BaseUCService;

import java.util.List;

public interface  UserWebService extends BaseUCService<Aauser>
{
    public List<UserinfoDTO> return_all_users();
    public String add_user(UserinfoDTO userinfoDTO) throws mException;


}
