package com.example.lib_management.common;

import javax.servlet.http.HttpServletRequest;

public class SessionManager {

    public static String getClientInfo(HttpServletRequest request)
    {
        String s = "";
        s += request.getRemoteAddr() + "---";
        s += request.getHeader("User-Agent").toString();
        return s;
    }




}
