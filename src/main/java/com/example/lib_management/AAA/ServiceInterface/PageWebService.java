package com.example.lib_management.AAA.ServiceInterface;

import com.example.lib_management.AAA.Entity.Aapage;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.PageinfoDTO;
import com.example.lib_management.baseDAOService.BaseDAOService;

import java.util.List;

public interface PageWebService extends BaseDAOService<Aapage> {

    public List<PageinfoDTO> return_all_pages();
    public String add_page(PageinfoDTO pageinfoDTO) throws mException;
    public PageinfoDTO return_page_by_id(int code);
    public String update_page(PageinfoDTO pageinfoDTO);


}
