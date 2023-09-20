package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.LogininfoDTO;



public interface AAAWebService {
    public void Login(LogininfoDTO logininfoDTO) throws Exception, mException;
}
