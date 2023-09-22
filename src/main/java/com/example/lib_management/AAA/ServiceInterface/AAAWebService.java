package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.LogininfoDTO;

import javax.servlet.http.HttpServletRequest;


public interface AAAWebService {
    public void Login(LogininfoDTO logininfoDTO, HttpServletRequest request) throws Exception, mException;



}
