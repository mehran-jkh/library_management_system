package com.example.lib_management.AAA.ServiceImpl;

import com.example.lib_management.AAA.Entity.Aapage;
import com.example.lib_management.AAA.ServiceInterface.PageWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.PageinfoDTO;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import com.example.lib_management.baseService.BaseUCServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImpl extends BaseUCServiceImpl<Aapage> implements PageWebService {


    public PageServiceImpl() {
        super(Aapage.class);
    }



    @Override
    public List<PageinfoDTO> return_all_pages()
    {
        List<Aapage> aapageList=super.FindAll();
        List<PageinfoDTO> pageinfoDTOS=new ArrayList<PageinfoDTO>();

        for (Aapage aapage:aapageList)
        {
            pageinfoDTOS.add(new PageinfoDTO(aapage));
        }
        return pageinfoDTOS;
    }



    @Override
    public String add_page(PageinfoDTO pageinfoDTO) throws mException {
        Aapage aapage=new Aapage();

        aapage.setName(pageinfoDTO.getName());
        aapage.setDescription(pageinfoDTO.getDescription());
        aapage.setUrl(pageinfoDTO.getUrl());

        return super.Add(aapage);
    }

    @Override
    public PageinfoDTO return_page_by_id(int code) {
        Aapage aapage=super.FindbyId(code);
        PageinfoDTO pageinfoDTO=new PageinfoDTO(aapage);
        return pageinfoDTO;
    }

    @Override
    public String update_page(PageinfoDTO pageinfoDTO) {
        Aapage aapage=new Aapage(pageinfoDTO);
         super.Edit(aapage);
         return "a message!!!";
    }


}
