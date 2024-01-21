package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.model.LogininfoDTO;
import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;

import javax.servlet.http.HttpServletRequest;


public interface AAAWebService
{
    public void Login(LogininfoDTO logininfoDTO, HttpServletRequest request) throws Exception , RepeatedPassword;

    public String Logout( HttpServletRequest request)  ;

}
