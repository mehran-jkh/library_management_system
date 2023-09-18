package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.model.AccesslistDTO;
import com.example.lib_management.baseService.BaseUCService;
import com.example.lib_management.AAA.commons.exceptions.mException;

import java.util.List;

public interface  AccesslistWebService extends BaseUCService<Aaaccesslist> {
    public void Add(int RoleId, int Pages[]) throws mException;
    public int[] return_all_pages(int roleid);



}
