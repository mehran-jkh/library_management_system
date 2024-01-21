package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aauser;
import com.example.lib_management.AAA.ServiceInterface.UserWebService;
import com.example.lib_management.AAA.model.UserinfoDTO;

import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;

import com.example.lib_management.common.jpaOP;
import org.hibernate.Session;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl extends BaseUCServiceImpl<UserinfoDTO,Aauser> implements UserWebService
{
    public UserServiceImpl() throws InstantiationException, IllegalAccessException
    {
        super(UserinfoDTO.class, Aauser.class);
    }


    @PostConstruct
    void init()
    {
        System.out.println("Init method called for UserServiceImpl");
        modelmapper_config();
    }

    public void modelmapper_config()
    {
        TypeMap<Aauser, UserinfoDTO> propertyMapper1 = super.modelMapper.createTypeMap(Aauser.class, UserinfoDTO.class);
        propertyMapper1.addMapping(Aauser::getAarole, UserinfoDTO::setRoleinfodto);

        TypeMap<UserinfoDTO,Aauser > propertyMapper2 = super.modelMapper.createTypeMap(UserinfoDTO.class, Aauser.class);
        propertyMapper2.addMapping(UserinfoDTO::getRoleinfodto, Aauser::setAarole);

    }

    public boolean check_uniqueness_of_password(String password) throws RepeatedPassword
    {
        Session session=sessionFactory.openSession();
        List<Aauser> users = (List<Aauser>) session.createNamedQuery("Aauser.findbyPassword")
                .setParameter("pass_word",password ).getResultList();

        if(users.size()>0)
        {
             return false;
        }
        return true;
    }

    @Override
    public String add_model( UserinfoDTO userinfoDTO) throws RepeatedPassword
    {

        // checking uniqueness of password
        if(!check_uniqueness_of_password(userinfoDTO.getPassword()))
            throw new RepeatedPassword("this password has been already used. please use another password");
        return   super.add_model(userinfoDTO);
    }


    public String update_model( UserinfoDTO userinfoDTO )
    {
        List<Aauser> existinguser=  super.FindbyField("password" , jpaOP.Eq , userinfoDTO.getPassword());

        if(existinguser.size()!=0 && existinguser.get(0).getUser_id() != userinfoDTO.getUser_id() )
        {
            throw new RepeatedPassword("this password has been already used. please use another password");
        }
        return super.update_model(userinfoDTO);
    }


}
