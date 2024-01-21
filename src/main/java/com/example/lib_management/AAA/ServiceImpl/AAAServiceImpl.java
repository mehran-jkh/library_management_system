package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.Entity.Aasession;
import com.example.lib_management.AAA.Entity.Aauser;
import com.example.lib_management.AAA.ServiceInterface.AAAWebService;
import com.example.lib_management.AAA.commons.exceptions.InvalidCredential;
import com.example.lib_management.AAA.model.LogininfoDTO;
import com.example.lib_management.AAA.model.UserinfoDTO;

import com.example.lib_management.baseUCService.BaseUCServiceImpl;
import com.example.lib_management.common.SessionManager;
import com.example.lib_management.common.mCal;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class AAAServiceImpl extends BaseUCServiceImpl<UserinfoDTO , Aauser> implements AAAWebService {

    //////////////////////////////////////////////////////////////////// Login Method
    @Override
    public void Login(LogininfoDTO logininfoDTO,HttpServletRequest request) throws Exception {
        Session session=sessionFactory.openSession();



        //Validation
        List<Aauser> users = (List<Aauser>)session .createNamedQuery("Aauser.findbyUserPass")
                .setParameter("user_name", logininfoDTO.getUsername())
                .setParameter("pass_word", logininfoDTO.getPassword())
                .getResultList();

        if (users.size() <= 0)
            throw new InvalidCredential("user name or password is incorrect");

        // Login is OK
        Aauser user = users.get(0);

        //get User Access List to Session
        List<Aaaccesslist> roleAccessList = (List<Aaaccesslist>) session.createNamedQuery("Aaaccesslist.findAccessListbyRole")
                .setParameter("RoleId", user.getAarole().getId())
                .getResultList();

        HttpSession httpSession=request.getSession(true);
        httpSession.setAttribute("AccessList", roleAccessList); // putting accesslists in session for Authorization goals...

        httpSession.setAttribute("user", user);  // putting user also in session for some use-cases...

        Aasession aasession = new Aasession();
        aasession.setAauser(user);
        aasession.setLogindate(mCal.getCurrentDateTime());
        aasession.setCilent(SessionManager.getClientInfo(request));
        aasession.setIsmanuallylogout(false);


        session.getTransaction().begin();
        session.merge(user);
        session.save(aasession);
        session.getTransaction().commit();


        httpSession.setAttribute("SessionId", aasession.getId());


    }//////////////  end of LOGIN

    @Override
    public String Logout(HttpServletRequest request )
    {
        HttpSession httpSession=request.getSession(false);
        Aauser aauser= (Aauser) httpSession.getAttribute("user");
        if(aauser==null)
        {
            return "you are not logged in and you cannot logout";
        }

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Aasession aasession = session.find(Aasession.class, httpSession.getAttribute("SessionId"));
        aasession.setLogoutdate(mCal.getCurrentDateTime());
        aasession.setIsmanuallylogout(true);
        session.getTransaction().commit();

        httpSession.invalidate();

        return "you successfully logged out";
    }


    ////////////////////////////////////////////////////////////////////
}
