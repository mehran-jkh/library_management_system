package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.Entity.Aapage;
import com.example.lib_management.AAA.Entity.Aapagevisit;
import com.example.lib_management.AAA.Entity.Aasession;
import com.example.lib_management.AAA.ServiceInterface.LoadPageWebService;
import com.example.lib_management.baseService.BaseUCServiceImpl;
import com.example.lib_management.common.mCal;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoadPageServiceimpl extends BaseUCServiceImpl<Aapagevisit> implements LoadPageWebService  {



    /////////////////////////////////////////// check page access !!!
    @Override
    public boolean check_access_to_page(String page_url , HttpServletRequest request)
    {
        // checking if this page is accessible or not
        HttpSession httpSession= request.getSession(false);
        if(httpSession==null)
            return false;

        List<Aaaccesslist> aaaccesslists = (List<Aaaccesslist>) httpSession.getAttribute("AccessList");

        for (Aaaccesslist aaaccesslist:aaaccesslists)
        {
            if (aaaccesslist.getAapage().getUrl().equals(page_url))
            {
                this.add_pagevisit(aaaccesslist.getAapage().getId() , (Integer) httpSession.getAttribute("SessionId"));
                return true;
            }
        }
        return false;
    }


    /////////////////////////////////////////// Adding page-visit to database after visiting page
    @Override
    public void add_pagevisit(int PageId, int SessionId) {

        Session session=sessionFactory.openSession();


        session.getTransaction().begin();

        Aapage page = session.find(Aapage.class, PageId);
        Aasession httpsession = session.find(Aasession.class, SessionId);

        Aapagevisit aapagevisit = new Aapagevisit();
        aapagevisit.setAapage(page);
        aapagevisit.setAasession(httpsession);
        aapagevisit.setIndate(mCal.getCurrentDateTime());
        session.persist(aapagevisit);

        session.getTransaction().commit();

    }











}