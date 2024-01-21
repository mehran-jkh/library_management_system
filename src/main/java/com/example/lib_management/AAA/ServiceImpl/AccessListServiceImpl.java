package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.Entity.Aapage;
import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.ServiceInterface.AccesslistWebService;
import com.example.lib_management.AAA.model.AccesslistDTO;
import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import com.example.lib_management.common.jpaOP;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessListServiceImpl extends BaseUCServiceImpl<AccesslistDTO,Aaaccesslist> implements AccesslistWebService
{






    public AccessListServiceImpl() throws InstantiationException, IllegalAccessException
    {
        super(AccesslistDTO.class,Aaaccesslist.class);
    }

    @Override
    public String add_model(AccesslistDTO model) throws RepeatedPassword  // without model_mapper ...
    {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

        try {
            session.createNamedQuery("Aaaccesslist.deletebyid")
                    .setParameter("RoleId", model.getRole_id())
                    .executeUpdate();


            Aarole aarole = (Aarole) session.createNamedQuery("Aarole.findbyId")
                    .setParameter("RoleId", model.getRole_id())
                    .getSingleResult();

            for (int pageid : model.getPages_id())
            {
                Aaaccesslist aaaccesslist = new Aaaccesslist();
                aaaccesslist.setAarole(aarole);
                Aapage page = session.find(Aapage.class, pageid);
                aaaccesslist.setAapage(page);
                super.Add(aaaccesslist);
            }
            session.getTransaction().commit();
        }
        catch (RuntimeException exception)
        {
            session.getTransaction().rollback();
            System.out.println(exception.getCause());
            return "there is a problem please try later";

        }
        return "Access lists added successfully...!!!";
    }

    @Override
    public int[] load_accessed_pages(int roleid)
    {
        List<Aaaccesslist> aaaccesslists=super.FindbyField("aarole.id", jpaOP.Eq,roleid);
        List<Integer> list =aaaccesslists.stream().map(e -> e.getAapage().getId()).collect(Collectors.toList());
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }


}
