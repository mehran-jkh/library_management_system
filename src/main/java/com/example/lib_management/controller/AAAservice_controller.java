package com.example.lib_management.controller;


import com.example.lib_management.AAA.ServiceInterface.AAAWebService;
import com.example.lib_management.AAA.commons.exceptions.InvalidCredential;
import com.example.lib_management.AAA.model.LogininfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "logincontroller" )
public class AAAservice_controller {

    private AAAWebService aaaWebService;


    @Autowired
    public AAAservice_controller(AAAWebService aaaWebService) {
        this.aaaWebService = aaaWebService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String show_login_form(@ModelAttribute("loginDTO_key") LogininfoDTO logininfoDTO)
    {
        return "login";
    }

    @RequestMapping(value = "sbmit_login_form")
    public String submit_login_form(@ModelAttribute("loginDTO_key") LogininfoDTO logininfoDTO , BindingResult result, Model model, HttpServletRequest request) throws Exception
    {
        try
        {
            aaaWebService.Login(logininfoDTO, request);
        }
        catch (InvalidCredential invalidCredential)
        {
            result.addError(new ObjectError("bad_credential" ,invalidCredential.getMessage()));
            model.addAttribute("errors", result.getGlobalErrors());
            return "login";
        }
        return "redirect:/index.jsp";
    }


    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request  ,Model model )
    {
        String message;
        message= aaaWebService.Logout(request);
        List<ObjectError> objectErrors=new ArrayList<>();
        objectErrors.add(new  ObjectError("logout message", message));
        model.addAttribute("errors", objectErrors);
        return "error";

    }



}
