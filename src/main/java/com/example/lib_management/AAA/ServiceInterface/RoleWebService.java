package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.baseService.BaseUCService;

import java.util.List;

public interface RoleWebService extends BaseUCService<Aarole> {

    public List<RoleinfoDTO> return_all_roles();

    public String add_role(RoleinfoDTO roleinfoDTO) throws mException;

    public RoleinfoDTO return_roel_by_id(int id);

    public String update_role(RoleinfoDTO roleinfoDTO);



}
