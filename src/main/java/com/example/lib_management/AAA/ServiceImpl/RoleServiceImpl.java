package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.ServiceInterface.RoleWebService;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseUCServiceImpl<RoleinfoDTO , Aarole > implements RoleWebService {


    public RoleServiceImpl() throws InstantiationException, IllegalAccessException
    {
        super(RoleinfoDTO.class , Aarole.class);
    }

}
