package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.ServiceInterface.RoleWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.baseDAOService.BaseDAOServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl extends BaseDAOServiceImpl<Aarole> implements RoleWebService {


    public RoleServiceImpl() {
        super(Aarole.class);
    }


    // converting Entity_list to a dto_list !!!manually!!!
    @Override
     public List<RoleinfoDTO> return_all_roles()
     {
        List<Aarole> aaroleList=super.FindAll();
        List<RoleinfoDTO> roleinfoDTOS=new ArrayList<RoleinfoDTO>();

        for (Aarole aarole:aaroleList)
        {
            roleinfoDTOS.add(new RoleinfoDTO(aarole) );
        }
        return roleinfoDTOS;
     }

    @Override
    public String add_role(RoleinfoDTO roleinfoDTO) throws mException {
        Aarole aarole=new Aarole();

        aarole.setDescription(roleinfoDTO.getDescription());
        aarole.setMaxuser(roleinfoDTO.getMaxuser());
        aarole.setName(roleinfoDTO.getName());


        return super.Add(aarole);
    }

    @Override
    public RoleinfoDTO return_roel_by_id(int id) {
        Aarole aarole=super.FindbyId(id);
        RoleinfoDTO roleinfoDTO=new RoleinfoDTO(aarole);
        return roleinfoDTO;
    }

    @Override
    public String update_role(RoleinfoDTO roleinfoDTO) {

        Aarole aarole=new Aarole(roleinfoDTO);
        super.Edit(aarole);
        return "a message...!!!";
    }


}
