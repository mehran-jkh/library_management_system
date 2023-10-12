package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.baseDAOService.BaseDAOService;
import com.example.lib_management.AAA.commons.exceptions.mException;

public interface  AccesslistWebService extends BaseDAOService<Aaaccesslist> {
    public void Add(int RoleId, int Pages[]) throws mException;
    public int[] return_all_pages(int roleid);



}
