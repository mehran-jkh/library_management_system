package com.example.lib_management.controller;


import com.example.lib_management.AAA.ServiceInterface.AAAWebService;
import com.example.lib_management.AAA.model.LogininfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "logincontroller" )
public class Loginservice_controller {

    private AAAWebService aaaWebService;


    @Autowired
    public Loginservice_controller(AAAWebService aaaWebService) {
        this.aaaWebService = aaaWebService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String show_login_form(@ModelAttribute("loginDTO_key") LogininfoDTO logininfoDTO)
    {
        return "login";
    }

    @RequestMapping(value = "sbmit_login_form")
    public String submit_login_form(LogininfoDTO logininfoDTO, HttpServletRequest request) throws Exception
    {
        aaaWebService.Login(logininfoDTO,request);
        return "redirect:/logincontroller/login";
    }





}
