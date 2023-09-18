package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aauser;
import com.example.lib_management.AAA.ServiceInterface.UserWebService;
import com.example.lib_management.baseService.BaseUCServiceImpl;
import com.example.lib_management.AAA.commons.exceptions.mException;
import org.hibernate.Session;


import javax.transaction.Transactional;
import java.util.List;
//@Service
public class UserServiceImpl extends BaseUCServiceImpl<Aauser> implements UserWebService
{
    public UserServiceImpl(Class<Aauser> type)
    {
        super(type);
    }

    @Override
    @Transactional
    public String Add(Aauser user) throws mException {
        Session session=sessionFactory.openSession();
        List<Aauser> users = (List<Aauser>) session.createNamedQuery("Aauser.findbyUsername")
                .setParameter("user_name", user.getUsername()).getResultList();

        if(users.size()>0)
        {
         //   throw new mException("this user_name has been taken previously! please use another user_name");
        }
//        users=(List<Aauser>) em.createNamedQuery("Aauser.findbyPassword")
//                .setParameter("pass_word", user.getPassword()).getResultList();
//        if(users.size()>0)
//        {
//            throw new mException("this pass_word has been taken previously! please use another pass_word");
//        }




        // if reach this line means the username and password is unique
        // same password
        String s="";
        try {
            super.Add(user);
            s="successfully added new user to data base";
        }catch (Exception e){
            s="unseccessful Adding please try again!";
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


}
