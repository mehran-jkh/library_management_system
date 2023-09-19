package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.Entity.Aauser;
import com.example.lib_management.AAA.ServiceInterface.UserWebService;
import com.example.lib_management.AAA.commons.AAAtools;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.AAA.model.UserinfoDTO;
import com.example.lib_management.baseService.BaseUCServiceImpl;
import com.example.lib_management.AAA.commons.exceptions.mException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl extends BaseUCServiceImpl<Aauser> implements UserWebService
{
    public UserServiceImpl()
    {
        super(Aauser.class);
    }

    @Override
    public String Add(Aauser user) throws mException {
        Session session=sessionFactory.openSession();
        ///// checking uniqueness of username
        List<Aauser> users = (List<Aauser>) session.createNamedQuery("Aauser.findbyUsername")
                .setParameter("user_name", user.getUsername()).getResultList();

        if(users.size()>0)
        {
            throw new mException("this user_name has been taken previously! please use another user_name");
        }




        // if reach this line means the username  is unique
        // generating password
        String new_password= AAAtools.getRandomPassword(10);
        user.setPassword(new_password);

        String s="";
        try {
            super.Add(user);
            s="successfully added new user to data base";
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
            s="unseccessful adding please try again!";
        }
        return s;
    }

    @Override
    public Aauser Edit(Aauser entity) {
        return null;
    }

    @Override
    public void Remove(Aauser entity)
    {

    }
    ///////////////////////////////////////////// mvc related methods

    @Override
    public List<UserinfoDTO> return_all_users() {
        List<Aauser> aausers=super.FindAll();
        List<UserinfoDTO> userinfoDTOS=new ArrayList<UserinfoDTO>();

        for (Aauser aauser:aausers)
        {
            userinfoDTOS.add(new UserinfoDTO(aauser) );
        }
        return userinfoDTOS;
    }

    @Override
    public String add_user(UserinfoDTO userinfoDTO) throws mException {
        Session session=sessionFactory.openSession();

        Aarole aarole=new Aarole();
        aarole=session.find(Aarole.class,userinfoDTO.getAarole().getCode());

        session.close();
        Aauser aauser=new Aauser(userinfoDTO);
        aauser.setAarole(aarole);

        return this.Add(aauser);
    }


}
