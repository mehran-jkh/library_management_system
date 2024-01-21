package com.example.lib_management.AAA.ServiceInterface;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface LoadPageWebService {
    public boolean check_access_to_page(String page_url , HttpServletRequest request);

    public void add_pagevisit(int PageId, int SessionId);

    public void send_to_err_page(Model model);



}
