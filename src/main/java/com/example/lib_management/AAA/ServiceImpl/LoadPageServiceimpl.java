package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.ServiceInterface.LoadPageWebService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoadPageServiceimpl implements LoadPageWebService {


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
                return true;
        }
        return false;
    }
}
