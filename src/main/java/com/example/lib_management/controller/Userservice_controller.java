package com.example.lib_management.controller;


import com.example.lib_management.AAA.ServiceInterface.RoleWebService;
import com.example.lib_management.AAA.ServiceInterface.UserWebService;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.AAA.model.UserinfoDTO;
import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.costumSpringValidator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("usercontroller")
public class Userservice_controller {
    private UserWebService userWebService;
    private RoleWebService roleWebService;

    @Autowired
    public Userservice_controller(UserWebService userWebService,RoleWebService roleWebService)
    {
        this.userWebService=userWebService;
        this.roleWebService=roleWebService;
    }

    //////////////////////////////////////////////////////////////////////////// Show All Users
    @RequestMapping(value = "viewallusers", method = RequestMethod.GET)
    public String users_info_page(Model model)
    {
        model.addAttribute("useers_list_key", userWebService.return_all_models());
        return "view_all_users";
    }

    //////////////////////////////////////////////////////////////////////////// Add User
    @RequestMapping(value = "adduser",method = RequestMethod.GET)
    public String add_user_page( @ModelAttribute("user_key") UserinfoDTO userinfoDTO, Model model ) throws RepeatedPassword
    {
        model.addAttribute("roles_list_key",roleWebService.return_all_models());

        return "add_user";
    }
    @RequestMapping(value = "submit_adduser_form")
    public String add_user_submit(@Valid @ModelAttribute("user_key") UserinfoDTO userinfoDTO, BindingResult bindingResult, Model model) throws RepeatedPassword
    {
        model.addAttribute("roles_list_key",roleWebService.return_all_models());

        if(bindingResult.hasErrors())
            return "add_user";

        try
        {
            String message = userWebService.add_model(userinfoDTO);
            System.out.println(message);
        }
        catch (RepeatedPassword repeatedPassword)
        {
            bindingResult.rejectValue("password" , "password.repeated" , "the password is already used");
            return "add_user";
        }
        return "redirect:/usercontroller/viewallusers";
    }
    //////////////////////////////////////////////////////////////////////////// Edit User

    @RequestMapping(value = "edituser/{code}" ,method = RequestMethod.GET)
    public String show_edit_user_form(@PathVariable int code, Model model , HttpServletRequest request)
    {
        UserinfoDTO userinfoDTO=userWebService.return_model_by_id(code);
        model.addAttribute("roles_list_key",roleWebService.return_all_models());
        model.addAttribute("user_key",userinfoDTO);
        return "edit_user";
    }


    @RequestMapping(value ="submit_edit_user",method = RequestMethod.POST)
    public String submit_edit_user_form(@Valid @ModelAttribute("user_key") UserinfoDTO userinfoDTO,Model model ,BindingResult bindingResult, HttpServletRequest request) throws RepeatedPassword
    {
        if(bindingResult.hasErrors())
        {
            return "edit_user";
        }
        try
        {
            String message = userWebService.update_model(userinfoDTO);
            System.out.println(message);
        }
        catch (RepeatedPassword repeatedPassword)
        {
            model.addAttribute("roles_list_key",roleWebService.return_all_models());
            bindingResult.rejectValue("password" , "password.repeated" , "the password is already used");
            return "edit_user";
        }
        catch (Exception e)
        {
            bindingResult.addError(new ObjectError("global error","there is problem withe server please try again"));
            return "edit_user";
        }
        return "redirect:/usercontroller/viewallusers";
    }



    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        EmailValidator emailValidator=new EmailValidator();
        binder.addValidators(emailValidator);
    }


}
