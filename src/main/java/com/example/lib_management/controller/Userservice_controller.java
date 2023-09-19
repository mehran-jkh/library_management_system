package com.example.lib_management.controller;


import com.example.lib_management.AAA.ServiceInterface.RoleWebService;
import com.example.lib_management.AAA.ServiceInterface.UserWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.AAA.model.UserinfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("usercontroller")
public class Userservice_controller {
    private UserWebService userWebService;
    private RoleWebService roleWebService;

    @Autowired
    public Userservice_controller(UserWebService userWebService,RoleWebService roleWebService){
        this.userWebService=userWebService;
        this.roleWebService=roleWebService;
    }

    //////////////////////////////////////////////////////////////////////////// Show All Users
    @RequestMapping(value = "viewallusers", method = RequestMethod.GET)
    public String users_info_page(Model model)
    {
        model.addAttribute("useers_list_key", userWebService.return_all_users());
        return "view_all_users";
    }

    //////////////////////////////////////////////////////////////////////////// Add User
    @RequestMapping(value = "adduser",method = RequestMethod.GET)
    public String add_role_page(@ModelAttribute("user_key") UserinfoDTO userinfoDTO,Model model ) throws mException {

        model.addAttribute("roles_list_key",roleWebService.return_all_roles());
        return "add_user";
    }

    @RequestMapping(value = "submit_adduser_form")
    public String add_user_submit(UserinfoDTO userinfoDTO) throws mException {
        String message=  userWebService.add_user(userinfoDTO);
        System.out.println(message);

        return "redirect:/usercontroller/viewallusers";
    }








}
