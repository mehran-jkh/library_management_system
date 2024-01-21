package com.example.lib_management.controller;

import com.example.lib_management.AAA.ServiceInterface.LoadPageWebService;
import com.example.lib_management.AAA.ServiceInterface.RoleWebService;

import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rolecontroller")
public class Roleservice_controller {
   private RoleWebService roleService;
   private LoadPageWebService loadPageWebService ;



    @Autowired
    public Roleservice_controller(RoleWebService roleService  , LoadPageWebService loadPageWebService)
    {
        this.roleService=roleService;
        this.loadPageWebService=loadPageWebService;
    }
//////////////////////////////////////////////////////////////////////////// Add Role
    @RequestMapping(value = "addrole",method = RequestMethod.GET)
    public String add_role_page(@ModelAttribute ("role_key") RoleinfoDTO roleinfoDTO , HttpServletRequest request ,BindingResult result ,Model model) throws RepeatedPassword
    {
        // checking accessibility
        if (!loadPageWebService.check_access_to_page("http://localhost/rolecontroller/addrole", request))
        {
           loadPageWebService.send_to_err_page(model);
            return "error";
        }
        return "add_role";
    }

    @RequestMapping(value = "submit_addrole_form")
    public String add_role_submit(@Valid  @ModelAttribute ("role_key") RoleinfoDTO roleinfoDTO, BindingResult bindingResult,Model model, HttpServletRequest request) throws RepeatedPassword
    {
        // checking accessibility
        if (!loadPageWebService.check_access_to_page("http://localhost/rolecontroller/submit_addrole_form", request))
        {
            loadPageWebService.send_to_err_page(model);
            return "error";
        }

      if (bindingResult.hasErrors())
            return "add_role";
      String message=  roleService.add_model(roleinfoDTO);
      return "redirect:/rolecontroller/viewallroles";
    }
//////////////////////////////////////////////////////////////////////////// Show All Roles

    @RequestMapping(value = "viewallroles", method = RequestMethod.GET)
    public String roles_info_page(Model model  ,  HttpServletRequest request)
    {
        // checking accessibility
        if (!loadPageWebService.check_access_to_page("http://localhost/rolecontroller/viewallroles", request))
        {
            loadPageWebService.send_to_err_page(model);
            return "error";
        }



        model.addAttribute("roles_list_key", roleService.return_all_models());
        return "view_all_roles";
    }
////////////////////////////////////////////////////////////////////////////// Delete Role

    @RequestMapping(value = "deleterole/{code}",method = RequestMethod.GET)
    public String delete_role(@PathVariable int code ,HttpServletRequest request ,Model model)
    {
        // checking accessibility
        if (!loadPageWebService.check_access_to_page("http://localhost/rolecontroller/deleterole", request))
        {
            loadPageWebService.send_to_err_page(model);
            return "error";
        }

        roleService.delete_model(code);
        return "redirect:/rolecontroller/viewallroles";
    }
////////////////////////////////////////////////////////////////////////////// Edit Role

    @RequestMapping(value = "editrole/{code}" ,method = RequestMethod.GET)
    public String show_edit_role_form(@PathVariable int code,Model model ,HttpServletRequest request)
    {
        // checking accessibility
        if (!loadPageWebService.check_access_to_page("http://localhost/rolecontroller/editrole", request))
        {
            loadPageWebService.send_to_err_page(model);
            return "error";
        }

        RoleinfoDTO roleinfoDTO=roleService.return_model_by_id(code);
        model.addAttribute("role_key",roleinfoDTO);
        return "edit_role";
    }


    @RequestMapping(value ="submit_edit_role",method = RequestMethod.POST)
    public String submit_edit_role_form(@Valid @ModelAttribute("role_key") RoleinfoDTO roleinfoDTO, BindingResult bindingResult, Model model , HttpServletRequest request)
    {
        // checking accessibility
        if (!loadPageWebService.check_access_to_page("http://localhost/rolecontroller/submit_edit_role", request))
        {
            loadPageWebService.send_to_err_page(model);
            return "error";
        }

        if(bindingResult.hasErrors())
            return "edit_role";
        String message=  roleService.update_model(roleinfoDTO);
        System.out.println(message);
        return "redirect:/rolecontroller/viewallroles";
    }

}
