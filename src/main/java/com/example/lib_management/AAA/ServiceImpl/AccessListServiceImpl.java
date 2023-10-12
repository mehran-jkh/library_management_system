package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.Entity.Aapage;
import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.ServiceInterface.AccesslistWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.baseDAOService.BaseDAOServiceImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Service;


import java.util.List;

//import org.springframework.transaction.annotation.Transactional;
@Service
public class AccessListServiceImpl extends BaseDAOServiceImpl<Aaaccesslist> implements AccesslistWebService {




    public AccessListServiceImpl() {
        super(Aaaccesslist.class);
    }




    public void Add(int RoleId, int[] Pages) throws mException {
        Session session=sessionFactory.openSession();

        session.getTransaction().begin();
        session.createQuery("delete  FROM Aaaccesslist e where e.aarole.id=:RoleId").setParameter("RoleId",RoleId).executeUpdate();
        session.getTransaction().commit();

        Aarole aarole=session.find(Aarole.class,RoleId);

        for (int pageid : Pages)
        {
            Aaaccesslist aaaccesslist=new Aaaccesslist();
            aaaccesslist.setAarole(aarole);

            Aapage page=session.find(Aapage.class,pageid);
            aaaccesslist.setAapage(page);

            super.Add(aaaccesslist);
        }

    }

    @Override
    public int[] return_all_pages(int roleid)
    {
        List<Aaaccesslist> aaaccesslists=super.FindbyField("aarole.id","=",roleid);
        int a[]=new int[ aaaccesslists.size() ];
        int counter=0;

        for (Aaaccesslist aaaccesslist:aaaccesslists)
        {
            a[counter++]=aaaccesslist.getAapage().getId();
        }
        return a;
    }

}
