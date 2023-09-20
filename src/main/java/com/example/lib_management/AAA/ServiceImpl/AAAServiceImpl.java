package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.Entity.Aauser;
import com.example.lib_management.AAA.ServiceInterface.AAAWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.LogininfoDTO;
import com.example.lib_management.baseService.BaseUCServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Service
public class AAAServiceImpl extends BaseUCServiceImpl<Aauser>  implements AAAWebService {
//    @Autowired
//    HttpServletRequest request;
//
//    public HttpServletRequest getRequest() {
//        return request;
//    }
//
//
//    public void setRequest(HttpServletRequest request) {
//        this.request = request;
//    }

    @Override
    public void Login(LogininfoDTO logininfoDTO,HttpServletRequest request) throws Exception, mException {
        Session session=sessionFactory.openSession();

        //Syntax Check    !!! should it be here? or it must be done using validators? !!!



        //Validation

        List<Aauser> users = (List<Aauser>)session .createNamedQuery("Aauser.findbyUserPass").setParameter("user_name", logininfoDTO.getUsername())
                .setParameter("pass_word", logininfoDTO.getPassword()).getResultList();
        if (users.size() <= 0)
            throw new mException();

        // Login is OK
        Aauser user = users.get(0);

        //get User Access List to Session
        List<Aaaccesslist> roleAccessList = (List<Aaaccesslist>) session.createNamedQuery("Aaaccesslist.findRoleAccessList")
                .setParameter("RoleId", user.getAarole().getId()).getResultList();

        HttpSession httpSession=request.getSession();
        if (!(null == httpSession))
           httpSession.setAttribute("AccessList", roleAccessList);
    }//////////////  end of LOGIN
}
