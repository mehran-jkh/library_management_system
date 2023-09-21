package com.example.lib_management.controller;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.ServiceInterface.RoleWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;

import com.example.lib_management.AAA.model.RoleinfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("rolecontroller")
public class Roleservice_controller {
   private RoleWebService roleService;

    @Autowired
    public Roleservice_controller(RoleWebService roleService){
        this.roleService=roleService;
    }


//////////////////////////////////////////////////////////////////////////// Add Role
    @RequestMapping(value = "addrole",method = RequestMethod.GET)
    public String add_role_page(@ModelAttribute ("role_key") RoleinfoDTO roleinfoDTO , HttpServletRequest request) throws mException {

        // checking if this page is accessable or not
        HttpSession httpSession= request.getSession(false);
        if(httpSession==null)
            return "redirect:/logincontroller/login";

        List<Aaaccesslist> aaaccesslists = (List<Aaaccesslist>) httpSession.getAttribute("AccessList");

        for (Aaaccesslist aaaccesslist:aaaccesslists)
        {
            if (aaaccesslist.getAapage().getUrl().equals("http://localhost:8080/rolecontroller/addrole"))
                return "add_role";
        }

        return "redirect:/logincontroller/login";
    }

    @RequestMapping(value = "submit_addrole_form")
    public String add_role_submit(RoleinfoDTO roleinfoDTO) throws mException {
      String message=  roleService.add_role(roleinfoDTO);
      System.out.println(message);

      return "redirect:/rolecontroller/viewallroles";
    }
//////////////////////////////////////////////////////////////////////////// Show All Roles

    @RequestMapping(value = "viewallroles", method = RequestMethod.GET)
    public String roles_info_page(Model model)
    {
        System.out.println("entering viewallroles...");
        model.addAttribute("roles_list_key", roleService.return_all_roles());

        return "view_all_roles";
    }
//////////////////////////////////////////////////////////////////////////// Delete Role

    @RequestMapping(value = "deleterole/{code}",method = RequestMethod.GET)
    public String delete_role(@PathVariable int code){
        System.out.println("inside delete method with code:"+code);
        roleService.Remove(code);


        return "redirect:/rolecontroller/viewallroles";
    }
//////////////////////////////////////////////////////////////////////////// Edit Role

    @RequestMapping(value = "editrole/{code}" ,method = RequestMethod.GET)
    public String show_edit_role_form(@PathVariable int code,Model model){
        RoleinfoDTO roleinfoDTO=roleService.return_roel_by_id(code);
        model.addAttribute("role_key",roleinfoDTO);

        return "edit_role";
    }


    @RequestMapping(value ="submit_edit_role/submit_edit_page",method = RequestMethod.POST)
    public String submit_edit_role_form(RoleinfoDTO roleinfoDTO){
        String message=  roleService.update_role(roleinfoDTO);
        System.out.println(message);


        return "redirect:/rolecontroller/viewallroles";
    }

//////////////////////////////////////////////////////////////////////////// Edit Role























}
